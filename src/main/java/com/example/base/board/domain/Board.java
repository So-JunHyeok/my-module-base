package com.example.base.board.domain;

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
    Integer boardId;

    Integer boardCode;
    String title;
    String region;
    String content;
    String writer;
    int view_count;
    String status;
    String secretYn;
    String email;
    String tel;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    private boolean pinned;
    private LocalDateTime pinnedAt;

    public void pin() {
        this.pinned = true;
        this.pinnedAt = LocalDateTime.now();
    }

    public void unpin() {
        this.pinned = false;
        this.pinnedAt = null;
    }
}
