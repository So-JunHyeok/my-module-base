package com.example.base.security.auth.impl;

import com.example.base.security.auth.AuthService;
import com.example.base.security.auth.AuthType;
import com.example.base.security.auth.dto.AuthRequest;
import com.example.base.security.auth.dto.AuthResult;
import com.example.base.security.user.domain.User;
import com.example.base.security.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormAuthService implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean supports(AuthType authType){
        return authType == AuthType.FORM;
    }

    @Override
    public AuthResult authenticate(AuthRequest request){

        User user = userRepository.findByuserId(request.getUserName())
                .orElseThrow(() -> new RuntimeException("사용자 없음"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new RuntimeException("비밀번호 불일치");

        return AuthResult.success(user.getUserId());
    }

}


/*
 - 학습용 메모
 @RequiredArgsConstructor : final 이거나ㅣ @NonNull인 필드만 파라미터로 받는 생성자를 자동으로 만들어주는 롬북 어노테이션
 PasswordEncoder passwordEncoder : new BCryptPasswordEncoder(12); // 강도 증가 : 비밀번호 해시화
 ex)
     $2a$10$N9qo8uLOickgx2ZMRZo5i.u0ZP5fH7cM6tZ9pNn5u9y9X9QvH6S5G
    │ │  │   └────────── 솔트 ──────────┘ └── 해시 ──┘
    │ │  └─ cost (반복 횟수)
    │ └─ 버전
    └─ BCrypt 식별자
 */