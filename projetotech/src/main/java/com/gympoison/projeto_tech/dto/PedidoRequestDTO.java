package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PedidoRequestDTO(
@NotNull Integer id_pedido,
@NotNull Integer id_cliente,
@NotNull LocalDateTime data_pedido,
@NotNull String Status_pedido,
@NotNull Integer total_pedido,
@NotNull Integer id_forma_pagamento,
@NotNull String endereco_entrega,
@NotNull String observacoes) {
}

