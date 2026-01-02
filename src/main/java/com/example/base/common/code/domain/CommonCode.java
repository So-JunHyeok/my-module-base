package com.example.base.common.code.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_cmm_code")
@Getter
@NoArgsConstructor
public class CommonCode {
    @EmbeddedId
    private CommonCodeId id;

    @Column(name = "code_name")
    private String codeName;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "use_yn")
    private String useYn;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
