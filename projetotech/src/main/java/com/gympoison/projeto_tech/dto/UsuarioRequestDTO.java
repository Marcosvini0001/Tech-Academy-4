package com.gympoison.projeto_tech.dto;

import com.gympoison.projeto_tech.model.Usuario;
import jakarta.persistence.Column;

public record UsuarioRequestDTO(Integer id, String nome, Integer cep,
                                String email, String endereco, Integer senha) {
}
