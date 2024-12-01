package com.gympoison.projeto_tech.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PedidoRequestDTO(@NotNull Double id_pedido, @NotNull Integer id_cliente,
                                @NotNull Double data_pedido, @NotNull String status_pedido,
                                @NotNull Double total_pedido, @NotNull Double id_forma_pagamento,
                                @NotNull String endereco_entrega, @NotNull String observacoes) {}

