package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Table
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item;

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
    private String status;

    @Column
    private String data_cadastro;

    public Long getId_item() {
        return id_item;
    }

    public void setId_item(Long id_item) {
        this.id_item = id_item;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        Produto produto = (Produto) o;
        return Objects.equals(id_item, produto.id_item) && Objects.equals(nome_item, produto.nome_item) && Objects.equals(preco_atual, produto.preco_atual) && Objects.equals(estoque, produto.estoque) && Objects.equals(descricao, produto.descricao) && Objects.equals(categoria, produto.categoria) && Objects.equals(status, produto.status) && Objects.equals(data_cadastro, produto.data_cadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_item, nome_item, preco_atual, estoque, descricao, categoria, status, data_cadastro);
    }
}