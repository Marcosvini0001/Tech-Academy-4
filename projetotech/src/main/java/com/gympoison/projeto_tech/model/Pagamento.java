package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Column
    private String pagamento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pagamento;

    @Column
    private Integer id_pedido;

    @Column
    private Date data_pagamento;

    @Column
    private BigDecimal valor_pagamento;

    @Column
    private Enum status_pagamento;

    @Column
    private Integer id_forma_pagamento;
    
    @ManyToOne
    @JoinColumn(name = "id_item", referencedColumnName = "id_item")
    private Item item;

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(Integer id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public Enum getStatus_pagamento() {
        return status_pagamento;
    }

    public void setStatus_pagamento(Enum status_pagamento) {
        this.status_pagamento = status_pagamento;
    }

    public BigDecimal getValor_pagamento() {
        return valor_pagamento;
    }

    public void setValor_pagamento(BigDecimal valor_pagamento) {
        this.valor_pagamento = valor_pagamento;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public Integer getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(Integer id_pagamento) {
        this.id_pagamento = id_pagamento;
    }
}