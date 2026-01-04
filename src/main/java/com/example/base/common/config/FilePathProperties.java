package com.example.base.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "file.upload")
@Data
public class FilePathProperties {

    private String board;
}

/*
@ConfigurationProperties(prefix = "file.upload")
“설정 파일(application.properties / yml)에 있는
file.upload.* 값을 이 클래스 필드에 바인딩하겠다”

@Component
이 클래스를 스프링 컨테이너가 관리하는 객체(빈)로 등록해라”

“이 클래스를 스프링 빈으로 등록하고,
그 빈의 필드 값은 설정 파일에서 읽어서 채워라”
 */