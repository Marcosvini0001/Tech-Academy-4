package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ipedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item_pedido;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(nullable = false)
    private BigDecimal preco_unitario;

    @Column(nullable = false)
    private BigDecimal total_item;

    // Getters e setters

    public Integer getId_item_pedido() {
        return id_item_pedido;
    }

    public void setId_item_pedido(Integer id_item_pedido) {
        this.id_item_pedido = id_item_pedido;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(BigDecimal preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public BigDecimal getTotal_item() {
        return total_item;
    }

    public void setTotal_item(BigDecimal total_item) {
        this.total_item = total_item;
    }
}
