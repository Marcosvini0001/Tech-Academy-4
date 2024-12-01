package com.gympoison.projeto_tech.dto;

import java.math.BigDecimal;

public record ItemRequestDTO(String nome_item, BigDecimal preco_atual,
                             Integer estoque, String descricao, String categoria, String status){
}