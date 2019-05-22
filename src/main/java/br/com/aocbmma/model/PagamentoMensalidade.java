package br.com.aocbmma.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pagamento_mensalidade")
public class PagamentoMensalidade implements Serializable{

    private static final long serialVersionUID = -3197704146306474441L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @OneToOne
    @NotNull
    private SocioTransferencia socio;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_mensalidade;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_pagamento;


    public Integer getCod() {
        return this.cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public SocioTransferencia getSocio() {
        return this.socio;
    }

    public void setSocio(SocioTransferencia socio) {
        this.socio = socio;
    }

    public Date getData_mensalidade() {
        return this.data_mensalidade;
    }

    public void setData_mensalidade(Date data_mensalidade) {
        this.data_mensalidade = data_mensalidade;
    }

    public Date getData_pagamento() {
        return this.data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    
}