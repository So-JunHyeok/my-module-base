package com.example.base.consultation.dto;

import lombok.Data;

@Data
public class ConsultationWriteParam {
    private String typeCode;
    private String name;
    private String email;
    private String phone;
    private String content;
    private String region;
}
