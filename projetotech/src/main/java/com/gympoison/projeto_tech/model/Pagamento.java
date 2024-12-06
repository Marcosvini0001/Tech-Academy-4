package com.gympoison.projeto_tech.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Table(name = "pagamento")
@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pagamento;


    @Column(nullable = false)
    private BigDecimal valor_pagamento;

    @Column(nullable = false)
    private
    LocalDate data_pagamento;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    public Integer getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(Integer id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public BigDecimal getValor_pagamento() {
        return valor_pagamento;
    }

    public void setValor_pagamento(BigDecimal valor_pagamento) {
        this.valor_pagamento = valor_pagamento;
    }

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
