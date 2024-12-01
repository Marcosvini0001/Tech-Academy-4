package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotNull;

public record IpedidoRequestDTO(@NotNull Double id_pedido, 
@NotNull Double id_produto,
@NotNull Double quantidade,
@NotNull Double preco_unitario,
@NotNull Double total_item,
@NotNull Double id_item_pedido){}