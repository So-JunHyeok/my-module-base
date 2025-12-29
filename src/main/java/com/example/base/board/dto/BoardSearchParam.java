package com.example.base.board.dto;

import lombok.Data;

@Data
public class BoardSearchParam {

    // 필수
    private Integer boardCode;

    // 검색
    private String type;     // writer | content | email | tel | region
    private String keyword;

}
