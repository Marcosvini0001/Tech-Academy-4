package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table
public class Ipedido {
    @Column(name = "item_pedido")
    public String item_pedido;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item_pedido;

    @Column
    private Integer id_pedido;

    @Column
    private Integer id_produto;

    @Column
    private Integer quantidade;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco_unitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total_item;

    public String getItem_pedido() {
        return item_pedido;
    }

    public void setItem_pedido(String item_pedido) {
        this.item_pedido = item_pedido;
    }

    public BigDecimal getTotal_item() {
        return total_item;
    }

    public void setTotal_item(BigDecimal total_item) {
        this.total_item = total_item;
    }

    public BigDecimal getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(BigDecimal preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_item_pedido() {
        return id_item_pedido;
    }

    public void setId_item_pedido(Integer id_item_pedido) {
        this.id_item_pedido = id_item_pedido;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }
}