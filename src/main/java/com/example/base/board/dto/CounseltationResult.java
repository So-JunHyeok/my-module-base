package com.example.base.board.dto;

import com.example.base.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CounseltationResult {
    private String writer;
    private String content;
    private String email;
    private String tel;
    private String region;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CounseltationResult from(Board board) {
        return new CounseltationResult(
                board.getWriter(),
                board.getContent(),
                board.getEmail(),
                board.getTel(),
                board.getRegion(),
                board.getCreatedAt(),
                board.getUpdatedAt()
        );
    }

}
