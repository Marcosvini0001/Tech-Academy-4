package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotBlank;
public record CategoriaRequestDTO(@NotBlank Integer id
                                , @NotBlank String nome) {
}
