package com.example.base.board.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_board_code")
public class BoardCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String boardCode;
    private String boardType;
    private String boardName;
    private String useYn;
    private int sortOrder;
    private LocalDateTime createdAt;
}
