package com.example.base.consultation.repository;

import org.springframework.data.domain.Page;
import com.example.base.consultation.domain.Consultation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    /* 목록 */
    Page<Consultation> findByTypeCodeOrderByCreatedAtDesc(String typeCode, Pageable pageable);

    Page<Consultation> findByTypeCodeAndNameContainingOrderByCreatedAtDesc(String typeCode, String name, Pageable pageable);

    Page<Consultation> findByTypeCodeAndContentContainingOrderByCreatedAtDesc(String typeCode, String content, Pageable pageable);

    Page<Consultation> findByTypeCodeAndEmailContainingOrderByCreatedAtDesc(String typeCode, String email, Pageable pageable);

    Page<Consultation> findByTypeCodeAndPhoneContainingOrderByCreatedAtDesc(String typeCode, String phone, Pageable pageable);

    /* 상세 */
    Optional<Consultation> findByConsultationId(Long consultationId);

    /* 이전글(아이디 기준) */
    Optional<Consultation> findFirstByTypeCodeAndConsultationIdLessThanOrderByConsultationIdDesc(String typeCode, Long consultationId);

    /* 다음글(아이디 기준) */
    Optional<Consultation> findFirstByTypeCodeAndConsultationIdGreaterThanOrderByConsultationIdAsc(String typeCode, Long consultationId);


    /* 이전글(등록일 기준) */
    Optional<Consultation> findFirstByTypeCodeAndCreatedAtBeforeOrderByCreatedAtDesc(String typeCode, LocalDateTime createdAt);

    /* 다음글(등록일 기준) */
    Optional<Consultation> findFirstByTypeCodeAndCreatedAtAfterOrderByCreatedAtAsc(String typeCode, LocalDateTime createdAt);

    /* 고정글 관련 */
    long countByTypeCodeAndPinnedTrue(String typeCode);

    List<Consultation> findTop3ByTypeCodeAndPinnedTrueOrderByPinnedAtDesc(String typeCode);
}
