package com.gympoison.projeto_tech.dto;

import com.gympoison.projeto_tech.model.Usuario;
import jakarta.persistence.Column;

public record UsuarioRequestDTO(Integer id_usuario, String nm_usuario, Integer cep_usuario,
                                String email, String end_usuario, Integer senha) {
}
