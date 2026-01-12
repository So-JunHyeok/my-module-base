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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fileId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    private String fileName;
    private String fileOriginName;
    private LocalDateTime createdAt;



    public static BoardFile create(Board board, FileType fileType, String fileName, String fileOriginName){
        BoardFile file = new BoardFile();
        file.board = board;
        file.fileType = fileType;
        file.fileName = fileName;
        file.fileOriginName = fileOriginName;
        file.createdAt = LocalDateTime.now();
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