package com.gympoison.projeto_tech.dto;

import com.gympoison.projeto_tech.model.Pedido;
import com.gympoison.projeto_tech.model.Produto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record IpedidoRequestDTO(@NotNull Double id_pedido, 
@NotNull Double id_produto,
@NotNull Double quantidade,
@NotNull Double preco_unitario,
@NotNull Double total_item){}