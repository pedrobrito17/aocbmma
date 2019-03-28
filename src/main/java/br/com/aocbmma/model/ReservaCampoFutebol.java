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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reserva_campo_futebol")
public class ReservaCampoFutebol{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_reserva;

    @Column
    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date hora_inicio;

    @Column
    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date hora_termino;

    @OneToOne
    @NotNull
    private Socio socio;

    private String pagamento = "pendente"; //vencido realizado


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_reserva() {
        return this.data_reserva;
    }

    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Date getHora_inicio() {
        return this.hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_termino() {
        return this.hora_termino;
    }

    public void setHora_termino(Date hora_termino) {
        this.hora_termino = hora_termino;
    }

    public Socio getSocio() {
        return this.socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public String getPagamento() {
        return this.pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }


    
}