package com.example.base.security.auth.dto;

import com.example.base.security.auth.AuthType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequest {
    private String userName;
    private String password;
    private AuthType authType;
    private String token;
}
