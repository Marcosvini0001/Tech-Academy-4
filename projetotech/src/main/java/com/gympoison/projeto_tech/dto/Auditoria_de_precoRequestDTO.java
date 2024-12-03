package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record Auditoria_de_precoRequestDTO(@NotNull Integer id_auditoria,
                                           @NotNull Integer id_produto, @NotNull BigDecimal preco_novo,
                                            @NotNull BigDecimal data_alteracao,
                                           @NotNull String motivo) {
}
