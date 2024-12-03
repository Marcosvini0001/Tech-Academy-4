package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotNull;
import com.gympoison.projeto_tech.model.Ipedido;
import com.gympoison.projeto_tech.model.Item;

import java.math.BigDecimal;

public record IpedidoRequestDTO(@NotNull Integer id_pedido,
@NotNull Integer id_produto,
@NotNull Integer quantidade,
@NotNull BigDecimal preco_unitario,
@NotNull BigDecimal total_item,
@NotNull Integer id_item_pedido){}