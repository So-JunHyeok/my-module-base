package com.example.base.security.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue
    private  Long id;

    private String userId;
    private String password;
    private String role;
    private boolean enabled;

}
/*
 - 학습용 메모
 @GeneratedValue : pk 자동 생성 전략
 @Column(nullable = false) : 값이 비어있으면 안됨(not null)
  - 자바 객체에서 null이 절대 안 들어간다 x
  - 컴파일 타임에 막아준다 x
 @NotNull
 @Column(nullable = false, unique = true, length = 50)
 null 불가 / 중복 불가 / 길이 제한
 */