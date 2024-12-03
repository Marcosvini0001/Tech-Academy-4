package com.gympoison.projeto_tech.response;

import java.math.BigDecimal;

import com.gympoison.projeto_tech.model.Item;

public record ItemResponseDTO(String nome_item, BigDecimal preco_atual,
                             String descricao, String categoria, String status){
    public ItemResponseDTO(Item item) {
        this(item.getNome_item(), item.getPreco_atual(),item.getStatus(), item.getCategoria(), item.getDescricao());
    }

}
