package com.example.base.consultation.dto;


import com.example.base.consultation.domain.Consultation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ConsultationResult {
    private Long consultationId;

    private String typeCode;
    private String name;
    private String email;
    private String phone;
    private String content;
    private String status;
    private String region;
    private boolean pinned;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private SimpleConsultation prev;
    private SimpleConsultation next;

    public static ConsultationResult from(Consultation consultation){
        return new ConsultationResult(
                consultation.getConsultationId(),
                consultation.getTypeCode(),
                consultation.getName(),
                consultation.getEmail(),
                consultation.getPhone(),
                consultation.getContent(),
                consultation.getStatus(),
                consultation.getRegion(),
                consultation.isPinned(),
                consultation.getCreatedAt(),
                consultation.getUpdatedAt(),
                null,
                null
        );
    }

    public static ConsultationResult from(Consultation consultation, Consultation prev, Consultation next){
        return new ConsultationResult(
                consultation.getConsultationId(),
                consultation.getTypeCode(),
                consultation.getName(),
                consultation.getEmail(),
                consultation.getPhone(),
                consultation.getContent(),
                consultation.getStatus(),
                consultation.getRegion(),
                consultation.isPinned(),
                consultation.getCreatedAt(),
                consultation.getUpdatedAt(),
                prev == null ? null : new SimpleConsultation(prev),
                next == null ? null : new SimpleConsultation(next)

        );
    }
}
