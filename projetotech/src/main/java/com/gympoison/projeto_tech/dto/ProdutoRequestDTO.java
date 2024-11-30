package com.gympoison.projeto_tech.dto;

public record ProdutoRequestDTO(String nome, Double preco,
                                Integer quantidade, String descricao, String categoria, String status){
}