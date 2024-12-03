package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

@Entity
@Table(name = "forma_de_pagamento") // Nome da tabela no banco
public class FormaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_pagamento")
    private Integer id_forma_pagamento;

    @Column(name = "tipo_pagamento")
    private String tipo_pagamento;

    @Column(name = "descricao")
    private String Descricao;

    // Getters e Setters
    public Integer getIdFormaPagamento() {
        return id_forma_pagamento;
    }

    public void setIdFormaPagamento(Integer idFormaPagamento) {
        this.id_forma_pagamento = idFormaPagamento;
    }

    public String getTipoPagamento() {
        return tipo_pagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipo_pagamento = tipoPagamento;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }
}
