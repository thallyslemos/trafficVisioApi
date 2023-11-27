package com.thallys.trafficvision.dto;

import com.thallys.trafficvision.model.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class UsuarioDTO extends Usuario {
    @Email(message = "Email inválido")
    private String email;
    @Min(value = 6, message = "Senha deve ter no mínimo 6 caracteres")
    @NotEmpty(message = "Senha é obrigatória")
    private String senha;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
