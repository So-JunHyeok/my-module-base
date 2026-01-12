package com.example.base.board.dto;

import com.example.base.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardResponse {
    private Integer boardId;
    private String boardCode;
    private String writer;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean pinned;
    private LocalDateTime pinnedAt;
    private SimpleBoard prev;
    private SimpleBoard next;


    public static BoardResponse from(Board board) {
        return new BoardResponse(
                board.getBoardId(),
                board.getBoardCode(),
                board.getWriter(),
                board.getContent(),
                board.getCreatedAt(),
                board.getUpdatedAt(),
                board.isPinned(),
                board.getPinnedAt(),
                null,
                null
        );
    }
    public static BoardResponse from(Board board, Board prev, Board next) {
        return new BoardResponse(
                board.getBoardId(),
                board.getBoardCode(),
                board.getWriter(),
                board.getContent(),
                board.getCreatedAt(),
                board.getUpdatedAt(),
                board.isPinned(),
                board.getPinnedAt(),
                prev == null ? null : new SimpleBoard(prev),
                next == null ? null : new SimpleBoard(next)
        );
    }

}
