package com.example.base.common.code.dto;

import com.example.base.common.code.domain.CommonCode;

public record CommonCodeResponse(
        String code,
        String codeName
) {
    public static CommonCodeResponse from(CommonCode entity) {
        return new CommonCodeResponse(
                entity.getId().getCode(),
                entity.getCodeName()
        );
    }
}


/*
레코드 실험
 - private final String code;
 - private final String codeName;
 - 생성자
 - getter (code(), codeName())
 - equals / hashCode
 -toString

 DTO 생성시 반복되는 코드를 줄이기 위한 방법
 */