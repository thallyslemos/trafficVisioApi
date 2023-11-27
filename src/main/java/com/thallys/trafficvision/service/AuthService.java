package com.thallys.trafficvision.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.thallys.trafficvision.dto.AuthDTO;
import com.thallys.trafficvision.dto.TokenDTO;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public TokenDTO authenticate(AuthDTO authDTO) {

        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authDTO.getEmail(),
                    authDTO.getSenha());
            authenticationManager.authenticate(token);
            return tokenService.gerar(authDTO.getEmail());
        } catch (AuthenticationException e) {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}
