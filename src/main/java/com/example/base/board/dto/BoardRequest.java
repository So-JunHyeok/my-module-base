package com.example.base.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardRequest {
    String title;
    String content;
    String writer;
}
