package com.thallys.trafficvision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thallys.trafficvision.dto.UsuarioDTO;
import com.thallys.trafficvision.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid UsuarioDTO usuario) {
        usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // replicar nos outros controllers
    }
}
