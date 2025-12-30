package com.example.base.board.dto;

import com.example.base.board.domain.Board;
import lombok.Getter;

@Getter
public class SimpleBoard {

    private Integer boardId;
    private String writer;

    public SimpleBoard(Board board){
        this.boardId = board.getBoardId();
        this.writer = board.getWriter();
    }

}
