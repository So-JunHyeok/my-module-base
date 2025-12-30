package com.example.base.board.dto;

import com.example.base.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CounseltationResult {
    private Integer boardId;
    private Integer boardCode;
    private String writer;
    private String content;
    private String email;
    private String tel;
    private String region;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean pinned;
    private LocalDateTime pinnedAt;
    private SimpleBoard prev;
    private SimpleBoard next;


    public static CounseltationResult from(Board board) {
        return new CounseltationResult(
                board.getBoardId(),
                board.getBoardCode(),
                board.getWriter(),
                board.getContent(),
                board.getEmail(),
                board.getTel(),
                board.getRegion(),
                board.getCreatedAt(),
                board.getUpdatedAt(),
                board.isPinned(),
                board.getPinnedAt(),
                null,
                null
        );
    }
    public static CounseltationResult from(Board board, Board prev, Board next) {
        return new CounseltationResult(
                board.getBoardId(),
                board.getBoardCode(),
                board.getWriter(),
                board.getContent(),
                board.getEmail(),
                board.getTel(),
                board.getRegion(),
                board.getCreatedAt(),
                board.getUpdatedAt(),
                board.isPinned(),
                board.getPinnedAt(),
                prev == null ? null : new SimpleBoard(prev),
                next == null ? null : new SimpleBoard(next)
        );
    }

}
