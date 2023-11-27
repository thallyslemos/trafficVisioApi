package com.thallys.trafficvision.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.thallys.trafficvision.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    Boolean existsByEmail(String email);
}
