package com.example.base.consultation.service;

import com.example.base.consultation.domain.Consultation;
import com.example.base.consultation.dto.ConsultationResult;
import com.example.base.consultation.dto.ConsultationSearchParam;
import com.example.base.consultation.repository.ConsultationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultationService {
    private final ConsultationRepository consultationRepository;

    public Page<ConsultationResult> consultationSearch(ConsultationSearchParam param, Pageable pageable){
        if(param.getKeyword() == null || param.getKeyword().isBlank()){
            return consultationRepository.findByTypeCodeOrderByCreatedAtDesc(param.getTypeCode(), pageable)
                    .map(ConsultationResult :: from);
        }

        switch (param.getType()){
            case "name" : return consultationRepository.findByTypeCodeAndNameContainingOrderByCreatedAtDesc(param.getTypeCode(), param.getKeyword(), pageable)
                    .map(ConsultationResult :: from);
            case "content" : return consultationRepository.findByTypeCodeAndContentContainingOrderByCreatedAtDesc(param.getTypeCode(), param.getKeyword(), pageable)
                    .map(ConsultationResult :: from);
            case "email" : return consultationRepository.findByTypeCodeAndEmailContainingOrderByCreatedAtDesc(param.getTypeCode(), param.getKeyword(), pageable)
                    .map(ConsultationResult :: from);
            case "phone" : return consultationRepository.findByTypeCodeAndPhoneContainingOrderByCreatedAtDesc(param.getTypeCode(), param.getKeyword(), pageable)
                    .map(ConsultationResult :: from);
            default : return consultationRepository.findByTypeCodeOrderByCreatedAtDesc(param.getTypeCode(), pageable)
                    .map(ConsultationResult :: from);
        }
    }

    public ConsultationResult consultationData(String typeCode, Long consultationId){
        Consultation data = consultationRepository.findByConsultationId(consultationId)
                .orElseThrow(() -> new IllegalArgumentException("상담글 없음"));

        Consultation prev = consultationRepository.findFirstByTypeCodeAndCreatedAtBeforeOrderByCreatedAtDesc(typeCode, data.getCreatedAt())
                .orElse(null);

        Consultation next = consultationRepository.findFirstByTypeCodeAndCreatedAtAfterOrderByCreatedAtAsc(typeCode, data.getCreatedAt())
                .orElse(null);

        return ConsultationResult.from(data, prev, next);
    }

    /* 고정글 조회 */
    public List<ConsultationResult> pinConsultationList(String typeCode){
        return consultationRepository.findTop3ByTypeCodeAndPinnedTrueOrderByPinnedAtDesc(typeCode)
                .stream().map(ConsultationResult::from).toList();
    }

    /* 고정글 상태 변경*/
    @Transactional
    public boolean togglePin(Long consultationId, String typeCode){

        Consultation consultation = consultationRepository.findByConsultationId(consultationId)
                .orElseThrow(() -> new IllegalArgumentException("글 없음"));

        if(consultation.isPinned()){
            consultation.unpin();
            return false;
        }

        long pinnedCount = consultationRepository.countByTypeCodeAndPinnedTrue(typeCode);

        if(pinnedCount >= 3){
            throw new IllegalArgumentException("고정글은 최대 3개까지 가능합니다.");
        }

        consultation.pin();
        return true;
    }
}

/*
  @Transactional
  엔티티조회하면 - 영속상태 진입(?) 값이 변경되면 트랜잭션 종료 시점에서 Dirty Checking발생
  JPA가: 처음 상태 vs 지금 상태 비교 / 변경됨 감지 → UPDATE 자동 생성

 */