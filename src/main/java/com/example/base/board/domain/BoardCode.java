package com.example.base.board.domain;

import com.example.base.board.dto.CounseltationResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_board_code")
public class BoardCode {
    @Id
    @GeneratedValue
    private int boardCode;

    private String boardName;
    private String useYn;
    private int sortOrder;
    private LocalDateTime createdAt;
}
