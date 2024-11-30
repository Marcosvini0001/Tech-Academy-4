package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PagamentoRequestDTO(@NotBlank Double id_forma_pagamento,
                                    @NotBlank String status_pagamento,
                                    @NotBlank Double valor_pagamento,
                                    @NotBlank Double data_pagamento,
                                    @NotBlank Double id_pedido,
                                    @NotBlank Double id_pagamento)


{
}
