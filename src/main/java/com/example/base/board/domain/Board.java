package com.example.base.board.domain;

import com.example.base.board.dto.BoardWriteParam;
import com.example.base.security.auth.principal.CustomUserDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_board")
public class Board {
    @Id
    @GeneratedValue
    private Integer boardId;

    private Integer boardCode;
    private String title;
    private String region;
    private String content;
    private String writer;
    private int view_count;
    private String status;
    private String secretYn;
    private String email;
    private String tel;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean pinned;
    private LocalDateTime pinnedAt;
    private String category;

    public static Board create(BoardWriteParam param, CustomUserDetails user){
        Board board = new Board();
        board.boardCode = param.getBoardCode();
        board.title = param.getTitle();
        board.content = param.getContent();
        board.writer = user.getUsername();
        board.status = "OPEN";
        board.secretYn = "N";
        board.email = param.getEmail();
        board.tel = param.getTel();
        board.view_count = 0;
        board.pinned = false;
        board.createdAt = LocalDateTime.now();
        board.category = param.getCategory();

        return board;
    }

    public void pin() {
        this.pinned = true;
        this.pinnedAt = LocalDateTime.now();
    }

    public void unpin() {
        this.pinned = false;
        this.pinnedAt = null;
    }
}

/*
static 은 객체생성없이 사용가능 따라서 해당 메소드를 통해서 객체를 생성하도록 제한하는것이다.
- 그래야 미완성 객체를 방지
 */