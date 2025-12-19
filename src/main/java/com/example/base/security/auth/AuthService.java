package com.example.base.security.auth;

import com.example.base.security.auth.dto.AuthRequest;
import com.example.base.security.auth.dto.AuthResult;

public interface AuthService {

    boolean supports(AuthType authType);

    AuthResult authenticate(AuthRequest request);

}
