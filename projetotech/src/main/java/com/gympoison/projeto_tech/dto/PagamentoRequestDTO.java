package com.gympoison.projeto_tech.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


public record PagamentoRequestDTO(@NotBlank Integer id_forma_pagamento,
                                    @NotBlank String status_pagamento,
                                    @NotBlank BigDecimal valor_pagamento,
                                    @NotBlank LocalDateTime data_pagamento,
                                    @NotBlank Integer id_pedido,
                                    @NotBlank Integer id_pagamento)


{
}
