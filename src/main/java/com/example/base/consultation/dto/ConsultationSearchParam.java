package com.example.base.consultation.dto;

import lombok.Data;

@Data
public class ConsultationSearchParam {

    private Long consultationId;
    private String typeCode;

    // 검색
    private String type;
    private String keyword;

    //페이지 상태
    private int currentPage;

}
