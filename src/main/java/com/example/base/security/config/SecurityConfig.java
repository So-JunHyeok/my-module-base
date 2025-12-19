package com.example.base.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 2025.12.17 작성
 시큐리티 라이브러리 설정
 작성자 : 소준혁
 코드 진행 상태 : 시큐리티 기본설정(로그인[인증]기능 없음)
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/login",
                                "/css/**",
                                "/js/**",
                                "/images/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/main", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



/*
 - 학습용 메모
  @Configuration : 스프링 설정 클래스(이 클래스를 **프록시(CGLIB)**로 감쌈)
   -> @Bean 메서드 호출을 관리 대상으로 만듦 / Bean을 정의하는 설정 클래스다 의미
  @EnableWebSecurity : Spring Security 활성화 스위치 (Security Filter Chain을 등록)
   -> 웹 요청이 Spring Security 필터를 반드시 통과하게 만듦
  @Bean : 객체를 컨테이너에 등록하는 것
 */