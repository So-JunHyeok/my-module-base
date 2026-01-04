package com.example.base.security.auth.provider;

import com.example.base.security.auth.AuthService;
import com.example.base.security.auth.AuthType;
import com.example.base.security.auth.dto.AuthRequest;
import com.example.base.security.auth.dto.AuthResult;
import com.example.base.security.auth.principal.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FormAuthenticationProvider implements AuthenticationProvider {

    private final AuthService authService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        AuthResult result = authService.authenticate(
                new AuthRequest(username, password, AuthType.FORM, null)
        );

        CustomUserDetails userDetails =
                new CustomUserDetails(
                        result.getUserId(),
                        result.getUserName(),   // 로그인 ID
                        result.getName(),       // 사용자 이름
                        result.getRole()        // ex) ROLE_ADMIN
                );

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
