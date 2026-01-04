package com.example.base.board.service;

import com.example.base.board.domain.Board;
import com.example.base.board.dto.BoardWriteParam;
import com.example.base.board.dto.CounseltationResult;
import com.example.base.board.repository.BoardRepository;
import com.example.base.security.auth.principal.CustomUserDetails;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;



@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<CounseltationResult> conuseltationList(Integer boardCode, Pageable pageable){
        return boardRepository.findByBoardCodeOrderByCreatedAtDesc(boardCode, pageable)
                .map(CounseltationResult :: from);
    }
    /* 고정글 */
    public List<CounseltationResult> pinBoardList(Integer boardCode){
        return boardRepository.findTop3ByBoardCodeAndPinnedTrueOrderByPinnedAtDesc(boardCode)
                .stream()
                .map(CounseltationResult::from)
                .toList();   // Java 16+
    }

    @Transactional
    public boolean togglePin(int boardId, int boardCode) {

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

    public Page<CounseltationResult> conuseltationSearch(Integer boardCode, String searchType, String keyword, Pageable pageable){
        if (keyword == null || keyword.isBlank()) {
            return boardRepository.findByBoardCodeOrderByCreatedAtDesc(boardCode, pageable)
                    .map(CounseltationResult :: from);
        }

        switch (searchType) {
            case "writer" :
                return boardRepository.findByBoardCodeAndWriterContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            case "content" :
                return boardRepository.findByBoardCodeAndContentContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            case "email" :
                return boardRepository.findByBoardCodeAndEmailContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            case "tel" :
                return boardRepository.findByBoardCodeAndTelContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            case "region" :
                return boardRepository.findByBoardCodeAndRegionContainingOrderByCreatedAtDesc(boardCode, keyword, pageable)
                        .map(CounseltationResult :: from);
            default:
                return boardRepository.findByBoardCodeOrderByCreatedAtDesc(boardCode, pageable)
                        .map(CounseltationResult :: from);
        }
    }

    public CounseltationResult conuseltationData(int boardId, int boardCode){

        Board data = boardRepository.findByBoardIdAndBoardCode(boardId, boardCode)
               .orElseThrow(() -> new IllegalArgumentException("상담글 없음"));

        Board prev = boardRepository
                .findFirstByBoardCodeAndCreatedAtBeforeOrderByCreatedAtDesc(boardCode, data.getCreatedAt())
                .orElse(null);

        Board next = boardRepository
                .findFirstByBoardCodeAndCreatedAtAfterOrderByCreatedAtAsc(boardCode, data.getCreatedAt())
                .orElse(null);

        return CounseltationResult.from(data, prev, next);
    }
    @Transactional
    public void write(BoardWriteParam boardWritpeParam, CustomUserDetails loginUser)throws IOException {
        Board board = Board.create(boardWritpeParam, loginUser);
        boardRepository.save(board);
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