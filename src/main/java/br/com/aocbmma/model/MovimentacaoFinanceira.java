package br.com.aocbmma.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="movimentacao_financeira")
public class MovimentacaoFinanceira{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date periodo_inicial;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date periodo_final;

    @Column
    private String path_arquivo;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPeriodo_inicial() {
        return this.periodo_inicial;
    }

    public void setPeriodo_inicial(Date periodo_inicial) {
        this.periodo_inicial = periodo_inicial;
    }

    public Date getPeriodo_final() {
        return this.periodo_final;
    }

    public void setPeriodo_final(Date periodo_final) {
        this.periodo_final = periodo_final;
    }

    public String getPath_arquivo() {
        return this.path_arquivo;
    }

    public void setPath_arquivo(String path_arquivo) {
        this.path_arquivo = path_arquivo;
    }

}