package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotNull;
import com.gympoison.projeto_tech.model.Ipedido;

public record IpedidoRequestDTO(@NotNull Integer id_pedido,
@NotNull Integer id_produto,
@NotNull Integer quantidade,
@NotNull Integer preco_unitario,
@NotNull Integer total_item,
@NotNull Integer id_item_pedido){}