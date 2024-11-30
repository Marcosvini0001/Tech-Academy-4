package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

import java.util.Objects;

@Table
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedido;

    @Column
    private Double id_pedido;

    @Column
    private Double id_cliente;

    @Column
    private Double data_pedido;

    @Column
    private String status_pedido;

    @Column
    private Double total_pedido;

    @Column
    private Double id_forma_pagamento;

    @Column
    private String endereco_entrega;

    @Column
    private String observacoes;

    public Long getpedido() {

        return pedido;
    }

    public void setpedido(Long pedido) {

        this.pedido = pedido;
    }

    public Double getid_pedido() {

        return id_pedido;
    }

    public void setid_pedido(Double id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Double getdata_pedido() {

        return data_pedido;
    }

    public void setdata_pedido(Double cdata_pedido) {

        this.data_pedido = data_pedido;
    }

    public String getstatus_pedido() {

        return status_pedido;
    }

    public void setstatus_pedido(String status_pedido) {

        this.status_pedido = status_pedido;
    }

    public Double gettotal_pedido() {

        return total_pedido;
    }

    public void settotal_pedido(Double total_pedido) {

        this.total_pedido = total_pedido;
    }

    public Double getid_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setid_forma_pagamento(Double id_forma_pagamento) {

        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String getendereco_entrega() {

        return endereco_entrega;
    }

    public void setendereco_entrega(String endereco_entrega) {

        this.endereco_entrega = endereco_entrega;
    }

    public String getobservacoes() {

        return observacoes;
    }

    public void setobservacoes(String observacoes) {

        this.observacoes = observacoes;
    }
    
}

