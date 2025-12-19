package com.example.base.security.auth.dto;

import com.example.base.security.auth.AuthType;
import lombok.Data;

@Data
public class AuthRequest {
    private AuthType authType;
    private String userName;
    private String password;
    private String token;
}
