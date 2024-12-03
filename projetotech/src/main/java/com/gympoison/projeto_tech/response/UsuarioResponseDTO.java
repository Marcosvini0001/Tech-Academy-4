package com.gympoison.projeto_tech.response;

import com.gympoison.projeto_tech.model.Usuario;

    public record UsuarioResponseDTO(Integer id, String nome, Integer cep, String email, String endereco, String senha) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCep(), usuario.getEmail(), usuario.getEndereco(), usuario.getSenha());
    }
}
