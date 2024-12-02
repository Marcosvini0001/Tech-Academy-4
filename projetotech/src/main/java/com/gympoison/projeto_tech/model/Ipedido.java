package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;


@Entity
@Table
public class Ipedido {
    @Column(name = "item_pedido")
    private String item_pedido;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item_pedido;

    @Column
    private Double id_pedido;

    @Column
    private Double id_produto;

    @Column
    private Double quantidade;

    @Column
    private Double preco_unitario;

    @Column
    private Double total_item;


    public String getItem_pedido() {
        return item_pedido;
    }

    public void setItem_pedido(String item_pedido) {
        this.item_pedido = item_pedido;
    }

    public Double getTotal_item() {
        return total_item;
    }

    public void setTotal_item(Double total_item) {
        this.total_item = total_item;
    }

    public Double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(Double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getId_produto() {
        return id_produto;
    }

    public void setId_produto(Double id_produto) {
        this.id_produto = id_produto;
    }

    public Double getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Double id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getId_item_pedido() {
        return id_item_pedido;
    }

    public void setId_item_pedido(Integer id_item_pedido) {
        this.id_item_pedido = id_item_pedido;
    }
}