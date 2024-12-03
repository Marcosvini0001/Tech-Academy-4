package com.gympoison.projeto_tech.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ItemRequestDTO(Integer id_item,String nome_item, BigDecimal preco_atual,
                             Integer estoque, String descricao, String categoria, String status
                             ,LocalDateTime data_cadastro){

}