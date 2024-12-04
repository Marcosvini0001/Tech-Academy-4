package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
public class Ipedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item_pedido; // Essa é a chave primária

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false) // Use a coluna correta para o relacionamento com Pedido
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false) // Use a coluna correta para o relacionamento com Produto
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
