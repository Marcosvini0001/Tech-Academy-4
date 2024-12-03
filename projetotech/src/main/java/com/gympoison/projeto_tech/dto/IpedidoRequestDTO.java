package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotNull;
import com.gympoison.projeto_tech.model.Ipedido;
import com.gympoison.projeto_tech.model.Item;

import java.math.BigDecimal;

public record IpedidoRequestDTO( Integer id_pedido,
 Integer id_produto,
 Integer quantidade,
 BigDecimal preco_unitario,
 BigDecimal total_item,
 Integer id_item_pedido){}