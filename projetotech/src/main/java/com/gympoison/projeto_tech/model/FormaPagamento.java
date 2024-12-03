package com.gympoison.projeto_tech.model;

import jakarta.persistence.*;

@Table
@Entity
public class FormaPagamento {
    @Column(name = "forma_de_pagamento")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_forma_pagamento;

    @Column
    private String tipo_pagamento;

    @Column
    private String Descricao;

    public Integer getid_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setid_forma_pagamento(Integer id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String getdescricao() {
        return Descricao;
    }

    public void setdescricao(String descricao) {
        Descricao = descricao;
    }

    public String gettipo_pagamento() {
        return tipo_pagamento;
    }

    public void settipo_pagamento(String tipoPagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }
}
