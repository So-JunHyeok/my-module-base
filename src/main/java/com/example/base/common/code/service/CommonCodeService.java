package com.example.base.common.code.service;

import com.example.base.common.code.domain.CommonCode;
import com.example.base.common.code.dto.CommonCodeResponse;
import com.example.base.common.code.repository.CommonCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommonCodeService {

    private final CommonCodeRepository commonCodeRepository;

    public List<CommonCodeResponse> commCodeList(String codeGroup){
        return commonCodeRepository.findByIdGroupCode(codeGroup)
                .stream()
                .map(CommonCodeResponse :: from)
                .toList();
    }
}
/*
@RequiredArgsConstructor는 final 아니면 생성자 주입안됨
 -
 */