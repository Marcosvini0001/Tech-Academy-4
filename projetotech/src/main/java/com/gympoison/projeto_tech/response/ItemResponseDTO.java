package com.gympoison.projeto_tech.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.gympoison.projeto_tech.model.Item;
import org.hibernate.persister.entity.SingleTableEntityPersister;

public record ItemResponseDTO(Integer id_item, String nome_item, BigDecimal preco_atual,Integer estoque,String status, String categoria,
                               String descricao,
                              LocalDateTime data_cadastro){
    public ItemResponseDTO(Item item) {
        this(item.getId_item(), item.getNome_item(), item.getPreco_atual(),item.getEstoque(), item.getStatus(), item.getCategoria(), item.getDescricao()
        , item.getData_cadastro());
    }

}
