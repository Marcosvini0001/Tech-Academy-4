package com.gympoison.projeto_tech.dto;

import java.math.BigDecimal;
import com.gympoison.projeto_tech.model.Item;

public record ItemRequestDTO(String nome_item, BigDecimal preco_atual,
                             Integer estoque, String descricao, String categoria, Enum status){
}