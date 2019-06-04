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
@Table(name="socio_transferencia")
public class SocioTransferencia implements Serializable{

    private static final long serialVersionUID = 8152280460580031734L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @OneToOne
    private Socio socio;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_adesao;

    @Column
    private String status; //adimplente ou inadimplente


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

    public Date getData_adesao() {
        return this.data_adesao;
    }

    public void setData_adesao(Date data_adesao) {
        this.data_adesao = data_adesao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}