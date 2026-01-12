package com.example.base.consultation.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_consultation_type")
public class ConsultationCode {
    @Id
    private String typeCode;

    private String typeName;
    private String useYn;
    private int sortOrder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
