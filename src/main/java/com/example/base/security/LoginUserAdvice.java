package com.example.base.security;

import com.example.base.security.auth.principal.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class LoginUserAdvice {
    @ModelAttribute("loginUser")
    public CustomUserDetails loginUser(Authentication authentication) {
        if (authentication == null) return null;

        Object principal = authentication.getPrincipal();

        if (principal instanceof CustomUserDetails userDetails) {
            return userDetails;
        }
        return null;
    }
}
