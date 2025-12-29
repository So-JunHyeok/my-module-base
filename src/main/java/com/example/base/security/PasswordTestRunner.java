package com.example.base.security;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordTestRunner {

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void run() {
        String raw = "admin1234";
        String encoded = passwordEncoder.encode(raw);

        System.out.println("RAW      = " + raw);
        System.out.println("ENCODED  = " + encoded);
    }
}
