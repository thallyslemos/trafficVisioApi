package com.thallys.trafficvision.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.thallys.trafficvision.dto.UsuarioDTO;
import com.thallys.trafficvision.model.Usuario;
import com.thallys.trafficvision.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Usuario save(UsuarioDTO usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        System.out.println("----*-----"+ usuarioRepository.existsByEmail(usuario.getEmail()));
        Usuario usuarioToSave = new Usuario();

        usuarioToSave.setEmail(usuario.getEmail());
        usuarioToSave.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuarioToSave);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

}
