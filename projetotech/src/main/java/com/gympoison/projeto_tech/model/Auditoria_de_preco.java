package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Auditoria_de_preco {
    @Column(name = "auditoria_de_preco")
    private String auditoria_de_preco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_auditoria;

    @Column
    private Integer id_produto;

    @Column
    private BigDecimal preco_antigo;

    @Column
    private BigDecimal preco_novo;

    @Column
    private BigDecimal data_alteracao;

    @Column
    private String motivo;

    public Integer getId_auditoria() {
        return id_auditoria;
    }
    public void setId_auditoria(Integer id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    public Integer getId_produto(){
        return id_produto;
    }
    public void setId_produto(Integer id_produto){
        this.id_produto = id_produto;
    }

    public BigDecimal getpreco_antigo(){
        return preco_antigo;
    }
    public void setpreco_antigo(BigDecimal preco_antigo){
        this.preco_antigo = preco_antigo;
    }

    public BigDecimal getpreco_novo(){
        return preco_novo;
    }
    public void setpreco_novo(BigDecimal preco_novo){
        this.preco_novo = preco_novo;
    }

    public String getmotivo(){
        return motivo;
    }
    public void setmotivo(String motivo){
        this.motivo = motivo;
    }

    public BigDecimal getdata_alteracao(){
        return data_alteracao;
    }
    public void setdata_alteracao(BigDecimal data_alteracao){
        this.data_alteracao = data_alteracao;
    }

}
