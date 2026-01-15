package com.example.base.board.service;

import com.example.base.board.domain.Board;
import com.example.base.board.domain.BoardFile;
import com.example.base.board.domain.FileType;
import com.example.base.board.domain.command.BoardCommand;
import com.example.base.board.dto.BoardWriteParam;
import com.example.base.board.dto.BoardResponse;
import com.example.base.board.repository.BoardFileRepository;
import com.example.base.board.repository.BoardRepository;
import com.example.base.common.config.FilePathProperties;
import com.example.base.security.auth.principal.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardFileRepository boardFileRepository;
    private final FilePathProperties filePathProperties;
    public Page<BoardResponse> boardList(String boardCode, Pageable pageable){
        return boardRepository.findByBoardCodeOrderByCreatedAtDesc(boardCode, pageable)
                .map(BoardResponse:: from);
    }
    /* 고정글 */
    public List<BoardResponse> pinBoardList(String boardCode){
        return boardRepository.findTop3ByBoardCodeAndPinnedTrueOrderByPinnedAtDesc(boardCode)
                .stream()
                .map(BoardResponse::from)
                .toList();   // Java 16+
    }

    @Transactional
    public boolean togglePin(int boardId, String boardCode) {

        Board board = boardRepository.findByBoardIdAndBoardCode(boardId, boardCode)
                .orElseThrow(() -> new IllegalArgumentException("글 없음"));

        if (board.isPinned()) {
            board.unpin();
            return false;
        }

        long pinnedCount =
                boardRepository.countByBoardCodeAndPinnedTrue(boardCode);

        if (pinnedCount >= 3) {
            throw new IllegalStateException("고정글은 최대 3개까지 가능합니다.");
        }

        board.pin();
        return true;
    }

    public Page<BoardResponse> conuseltationSearch(String boardCode, String searchType, String keyword, Pageable pageable){
        if (keyword == null || keyword.isBlank()) {
            return boardRepository.findByBoardCodeOrderByCreatedAtDesc(boardCode, pageable)
                    .map(BoardResponse:: from);
        }

        switch (searchType) {
            case "writer" :
                return boardRepository.findByBoardCodeAndWriterContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(BoardResponse:: from);
            case "content" :
                return boardRepository.findByBoardCodeAndContentContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(BoardResponse:: from);
            default:
                return boardRepository.findByBoardCodeOrderByCreatedAtDesc(boardCode, pageable)
                        .map(BoardResponse:: from);
        }
    }

    public BoardResponse conuseltationData(int boardId, String boardCode){

        Board data = boardRepository.findByBoardIdAndBoardCode(boardId, boardCode)
               .orElseThrow(() -> new IllegalArgumentException("상담글 없음"));

        Board prev = boardRepository
                .findFirstByBoardCodeAndCreatedAtBeforeOrderByCreatedAtDesc(boardCode, data.getCreatedAt())
                .orElse(null);

        Board next = boardRepository
                .findFirstByBoardCodeAndCreatedAtAfterOrderByCreatedAtAsc(boardCode, data.getCreatedAt())
                .orElse(null);

        return BoardResponse.from(data, prev, next);
    }
    @Transactional(rollbackFor = Exception.class)
    public void write(BoardWriteParam param, CustomUserDetails loginUser)throws IOException {

        BoardCommand boardCommand = BoardCommand.boardWrite(
                param.getBoardCode(),
                param.getTitle(),
                param.getContent(),
                param.getWriter(),
                param.getCategory()
        );

        Board board = Board.create(boardCommand, loginUser);
        boardRepository.save(board);

        handleDefaultFiles(board, param);

    }

    private void handleDefaultFiles(Board board, BoardWriteParam param) throws IOException{
        if ("constructCase".equals(board.getBoardCode())) {
            saveBeforeAfterFileInfo(board, param);
        } else {
            saveFilesInfo(board, param);
        }
    }

    private void saveFilesInfo(Board board, BoardWriteParam param)throws IOException{
        if(param.getFiles() == null || param.getFiles().isEmpty()) return;

        List<String> savedFiles = new ArrayList<>();
        try {
            for(MultipartFile file : param.getFiles()){
                String saveFileName = saveFile(file);
                BoardFile boardFile = BoardFile.create(
                        board,
                        FileType.ATTACHMENT,
                        saveFileName,
                        file.getOriginalFilename()
                );
                boardFileRepository.save(boardFile);
                savedFiles.add(saveFileName);
            }
        }catch (Exception e){
            for (String file : savedFiles) {
                try {
                    Files.deleteIfExists(
                            Paths.get(filePathProperties.getBoard()).resolve(file)
                    );
                }catch (IOException ignored){}
            }
            throw e;
        }
    }

    private void saveBeforeAfterFileInfo(Board board, BoardWriteParam param)throws IOException{
        if(param.getBeforeFile() == null || param.getBeforeFile().isEmpty()) return;
        if(param.getAfterFile() == null || param.getAfterFile().isEmpty()) return;

        List<String> savedFiles = new ArrayList<>();

        try {
            MultipartFile beforeFile = param.getBeforeFile();
            MultipartFile afterFile = param.getAfterFile();

            String savedBeforeFileName = saveFile(beforeFile);
            String savedAfterFileName = saveFile(afterFile);

            BoardFile boardBeforeFile = BoardFile.create(
                    board,
                    FileType.BEFORE,
                    savedBeforeFileName,
                    beforeFile.getOriginalFilename()
            );
            boardFileRepository.save(boardBeforeFile);
            savedFiles.add(savedBeforeFileName);

            BoardFile boardAfterFile = BoardFile.create(
                    board,
                    FileType.AFTER,
                    savedAfterFileName,
                    afterFile.getOriginalFilename()
            );
            boardFileRepository.save(boardAfterFile);
            savedFiles.add(savedAfterFileName);

        }catch (Exception e){
            //파일 수동 롤백
            // 파일 저장 실패 시 RuntimeException 발생 → 트랜잭션 롤백
            // 파일 시스템은 트랜잭션 대상이 아니므로 수동 롤백 처리
            for (String file : savedFiles) {
                try {
                    Files.deleteIfExists(
                            Paths.get(filePathProperties.getBoard()).resolve(file)
                    );
                }catch (IOException ignored){}
            }
            throw e;
        }
    }


    private String saveFile(MultipartFile file)throws IOException{
        String uploadDir = filePathProperties.getBoard();
        Files.createDirectories(Paths.get(uploadDir));
        String originalName = file.getOriginalFilename();

        if (originalName == null) {
            throw new IllegalArgumentException("파일명이 없습니다.");
        }

        String ext = "";
        int dotIndex = originalName.lastIndexOf(".");
        if (dotIndex != -1) {
            ext = originalName.substring(dotIndex);
        }

        String savedName = UUID.randomUUID() + ext;

        Path savePath = Paths.get(uploadDir, savedName);
        file.transferTo(savePath.toFile());

        return savedName;
    }
}


/*
Builder 패턴 (필드가 많을떄) * 생성 규칙이 있는 도메인에서는 create()가 더 좋다
Board board = Board.builder()
        .boardCode(param.getBoardCode())
        .title(param.getTitle())
        .region(param.getRegion())
        .content(param.getContent())
        .writer(loginUser.getUserId())
        .email(param.getEmail())
        .tel(param.getTel())
        .secretYn(param.getSecretYn())
        .status("NORMAL")
        .viewCount(0)
        .build();

        @Transactional
        예외 발생시 롤백
 */

/*
롤백 코드?
        } catch (Exception e) {
            // 파일 롤백
            for (String savedFile : savedFiles) {
                try {
                    Files.deleteIfExists(
                            Paths.get(filePathProperties.getBoard(), savedFile)
                    );
                } catch (IOException ignore) {}
            }
            throw e;
        }
 */