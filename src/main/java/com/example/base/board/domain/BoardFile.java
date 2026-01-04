package com.example.base.board.domain;

import com.example.base.board.dto.BoardWriteParam;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_board_file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardFile {
    @Id
    @GeneratedValue
    private Integer fileId;

    private Integer boardId;
    private Integer boardCode;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    private String fileName;
    private String filePath;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    public static BoardFile create(Board board, BoardWriteParam param, FileType fileType){
        BoardFile file = new BoardFile();
        file.board = board;
        file.fileType = fileType;
        file.fileName = param.getAfterFile().getOriginalFilename();
        return file;
    }

}


/*

    1대 다 관계 설정 : BoardFile 엔티티는 하나의 Board에 속한다 (N : 1 관계)
    @ManyToOne(fetch = FetchType.LAZY)
    FetchType.LAZY : 연관된 엔티티를 지금 당장 안 가져오고, 필요할 때 가져와라
    FetchType.EAGER : 항상 불러옴


    - enum 값을 DB에 문자열로 저장한다.
    @Enumerated(EnumType.STRING)
    private FileType fileType; // BEFORE / AFTER
 */