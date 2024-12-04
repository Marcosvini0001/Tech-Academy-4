package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "id_pedido")
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    @Column
    private Integer id_cliente;

    @Temporal(TemporalType.TIMESTAMP) // Define que o campo será armazenado como data e hora
    @Column(nullable = false)
    private LocalDateTime data_pedido;

    @Column
    private String status_pedido;

    @Column
    private BigDecimal total_pedido;

    @Column
    private Integer id_forma_pagamento;

    @Column
    private String endereco_entrega;

    @Column
    private String observacoes;


    public Integer getid_pedido(@NotNull Integer integer) {
        return id_pedido;
    }

    public void setid_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getid_cliente() {
        return id_cliente;
    }

    public void setid_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDateTime getdata_pedido( LocalDateTime localDateTime) {

        return data_pedido;
    }
    public void setdata_pedido(LocalDateTime data_pedido) {

        this.data_pedido = data_pedido;
    }

    public String getstatus_pedido() {

        return status_pedido;
    }

    public void setstatus_pedido(String status_pedido) {

        this.status_pedido = status_pedido;
    }

    public BigDecimal gettotal_pedido() {

        return total_pedido;
    }

    public void settotal_pedido(BigDecimal total_pedido) {

        this.total_pedido = total_pedido;
    }

    public Integer getid_forma_pagamento( Integer integer) {
        return id_forma_pagamento;
    }

    public void setid_forma_pagamento(Integer id_forma_pagamento) {

        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String getendereco_entrega( String s) {

        return endereco_entrega;
    }

    public void setendereco_entrega(String endereco_entrega) {

        this.endereco_entrega = endereco_entrega;
    }

    public String getobservacoes( String observacoes) {

        return this.observacoes;
    }

    public void setobservacoes(String observacoes) {

        this.observacoes = observacoes;
    }

    
}

