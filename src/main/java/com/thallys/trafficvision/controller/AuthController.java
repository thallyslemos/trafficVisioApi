package com.thallys.trafficvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thallys.trafficvision.dto.AuthDTO;
import com.thallys.trafficvision.dto.TokenDTO;
import com.thallys.trafficvision.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<TokenDTO> authenticate(@RequestBody @Valid AuthDTO auth) {
        return ResponseEntity.ok(authService.authenticate(auth));
    }
}
