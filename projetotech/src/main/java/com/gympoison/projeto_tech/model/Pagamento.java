package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;


@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Column
    private String pagamento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id_pagamento;

    @Column
    private Double id_pedido;

    @Column
    private Double data_pagamento;

    @Column
    private Double valor_pagamento;

    @Column
    private String status_pagamento;

    @Column
    private Double id_forma_pagamento;
    
    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    private Item item;
    public Double getId_pagamento() {
        return id_pagamento;
    }
    public void setId_pagamento(Double id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public Double getId_pedido(){
        return id_pedido;
    }
    public void setId_pedido(Double id_pedido){
        this.id_pedido = id_pedido;
    }

    public Double getData_pagamento(){
        return data_pagamento;
    }
    public void setData_pagamento(Double data_pagamento){
        this.data_pagamento = data_pagamento;
    }

    public Double getValor_pagamento(){
        return valor_pagamento;
    }
    public void setValor_pagamento(Double valor_pagamento){
        this.valor_pagamento = valor_pagamento;
    }

    public String getStatus_pagamento(){
        return status_pagamento;
    }
    public void setStatus_pagamento(String status_pagamento){
        this.status_pagamento = status_pagamento;
    }

    public Double getId_forma_pagamento(){
        return id_forma_pagamento;
    }
    public void setId_forma_pagamento(Double id_forma_pagamento){
        this.id_forma_pagamento = id_forma_pagamento;
    }

}