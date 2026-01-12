package com.example.base.consultation.dto;

import com.example.base.consultation.domain.Consultation;
import lombok.Getter;

@Getter
public class SimpleConsultation {
    private Long consultationId;
    private String name;

    public SimpleConsultation(Consultation consultation){
        this.consultationId = consultation.getConsultationId();
        this.name = consultation.getName();
    }
}
