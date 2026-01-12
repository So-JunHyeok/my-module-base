package com.example.base.consultation.domain;

import com.example.base.consultation.dto.ConsultationWriteParam;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "tb_consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultationId;

    private String typeCode;
    private String name;
    private String email;
    private String phone;
    private String content;
    private String status;
    private boolean pinned;
    private String region;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime pinnedAt;

    public static Consultation create(ConsultationWriteParam param){
        Consultation consultation = new Consultation();
        consultation.typeCode = param.getTypeCode();
        consultation.name = param.getName();
        consultation.phone = param.getPhone();
        consultation.content = param.getContent();
        consultation.status = "RECEIVED";
        consultation.createdAt = LocalDateTime.now();
        consultation.pinned = false;
        consultation.region = param.getRegion();
        return consultation;
    }

    public void pin(){
        this.pinned = true;
        this.pinnedAt = LocalDateTime.now();
    }

    public void unpin(){
        this.pinned = false;
        this.pinnedAt = null;
    }
}
