package com.example.base.board.dto;

import lombok.Data;

@Data
public class BoardSearchParam {

    // 필수
    private Integer boardId;
    private Integer boardCode;

    // 검색
    private String type;
    private String keyword;

    //페이지 상태
    private int currentPage;

    // writer | content | email | tel | region : 상속으로 구현

}
