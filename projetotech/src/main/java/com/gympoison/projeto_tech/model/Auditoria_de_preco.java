package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

@Entity
@Table
public class Auditoria_de_preco {
    @Column(name = "auditoria_de_preco")
    private String Auditoria_de_preco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Double id_auditoria;

    @Column
    private Double id_produto;

    @Column
    private Double preco_antigo;

    @Column
    private Double preco_novo;

    @Column
    private Double data_alteracao;

    @Column
    private String motivo;

    public Double getId_auditoria() {
        return id_auditoria;
    }
    public void setId_auditoria(Double id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    public Double getId_produto(){
        return id_produto;
    }
    public void setId_produto(Double id_produto){
        this.id_produto = id_produto;
    }

    public Double getpreco_antigo(){
        return preco_antigo;
    }
    public void setpreco_antigo(Double preco_antigo){
        this.preco_antigo = preco_antigo;
    }

    public Double getpreco_novo(){
        return preco_novo;
    }
    public void setpreco_novo(Double preco_novo){
        this.preco_novo = preco_novo;
    }

    public String getmotivo(){
        return motivo;
    }
    public void setmotivo(String motivo){
        this.motivo = motivo;
    }

    public Double getdata_alteracao(){
        return data_alteracao;
    }
    public void setdata_alteracao(Double data_alteracao){
        this.data_alteracao = data_alteracao;
    }

}
