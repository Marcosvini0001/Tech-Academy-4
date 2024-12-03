package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Table
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_item;

    @Column
    private String nome_item;

    @Column
    private BigDecimal preco_atual;

    @Column
    private Integer estoque;

    @Column
    private String descricao;

    @Column
    private String categoria;


    @Column
    private Enum status;

    @Temporal(TemporalType.TIMESTAMP) // Define que o campo será armazenado como data e hora
    @Column(nullable = false)
    private LocalDateTime data_cadastro;

    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Enum status) {
        this.status = status;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getNome_item() {
        return nome_item;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public BigDecimal getPreco_atual() {
        return preco_atual;
    }

    public void setPreco_atual(BigDecimal preco_atual) {
        this.preco_atual = preco_atual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id_item, item.id_item) && Objects.equals(nome_item, item.nome_item) && Objects.equals(preco_atual, item.preco_atual) && Objects.equals(estoque, item.estoque) && Objects.equals(descricao, item.descricao) && Objects.equals(categoria, item.categoria) && Objects.equals(status, item.status) && Objects.equals(data_cadastro, item.data_cadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_item, nome_item, preco_atual, estoque, descricao, categoria, status, data_cadastro);
    }
}