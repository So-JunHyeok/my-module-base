package com.example.base.common.code.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CommonCodeId implements Serializable {

    @Column(name = "group_code")
    private String groupCode;

    @Column(name = "code")
    private String code;
}

/*
학습
implements Serializable
 - 직렬화(객체 -> 바이트)해도 안전하다는 표시

@Embeddable
 - 다른 엔티티의 식별자/값 객체로 사용한다는 어노테이션(이클래스는 독립 엔티티X
@EqualsAndHashCode
 - 해당 객체의 동등성 기준을 정의
  -> (없으면)
    -- 같은 DB row인데 다른 객체로 인식
    -- find / save / merge 오동작
    -- 캐시 중복
    -- 버그 찾기 어려워짐.
 */