package br.com.aocbmma.model;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="solicitacao_carteira_identificacao")
public class SolicitacaoCarteiraIdentificacao{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @OneToOne
    @NotNull
    private Socio socio;
    
    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date data_solicitacao;
    
    @Column
    @NotNull
    private String status;
    
    @Column
    @NotEmpty
    private String foto;

    public SolicitacaoCarteiraIdentificacao(){
        data_solicitacao = new Date();
    }

    public Integer getCod() {
        return this.cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Socio getSocio() {
        return this.socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Date getData_solicitacao() {
        return this.data_solicitacao;
    }

    public void setData_solicitacao(Date data_solicitacao) {
        this.data_solicitacao = data_solicitacao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}