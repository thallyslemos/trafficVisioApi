package com.thallys.trafficvision.service;


import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.thallys.trafficvision.dto.TokenDTO;

@Service
public class TokenService {
    @Value("${jwt.secret}")
    private String token;

    public TokenDTO gerar(String email) {
        return new TokenDTO(JWT.create()
                .withSubject(email)
                .withExpiresAt(LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256(token)));

    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(this.token))
                .build()
                .verify(token)
                .getSubject();
    }
}
