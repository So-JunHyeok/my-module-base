package com.example.base.security.auth.dto;

import com.example.base.security.auth.AuthType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResult {
    private boolean success;
    private Long userId;
    private String userName;
    private String name;
    private String role;



    public static AuthResult success(Long userId, String userName, String name, String role){
        return new AuthResult(
                true,
                userId,
                userName,
                name,
                role
        );
    }
}


/*
 - 학습용 메모
 @AllArgsConstructor는 룸북 라이브러리 어노테이션으로 클래스 내 모든 필드(맴버 변수)를 파라미터로 받는 생성자 자동생성
  AuthResult(true, userId); -> 생성자가 생성되어 있으니 사용 가능
 */
