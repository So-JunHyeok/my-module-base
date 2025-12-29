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
    int boardId;

    String boardCode;
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
}
