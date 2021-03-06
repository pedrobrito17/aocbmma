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

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reserva_chale")
public class ReservaChale{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_solicitacao = new Date(System.currentTimeMillis());
    
    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_entrada;
    
    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_saida;
    
    @OneToOne
    private Socio socio;
    
    @OneToOne
    private Chale chale;

    @Column
    private String pagamento = "pendente"; //vencido realizado

    @Column(precision=4, scale=2)
    @Type(type="float")
    @NotNull
    private float valor_reserva;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_solicitacao() {
        return this.data_solicitacao;
    }

    public void setData_solicitacao(Date data_solicitacao) {
        this.data_solicitacao = data_solicitacao;
    }

    public Date getData_entrada() {
        return this.data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return this.data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public Socio getSocio() {
        return this.socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Chale getChale() {
        return this.chale;
    }

    public void setChale(Chale chale) {
        this.chale = chale;
    }

    public String getPagamento() {
        return this.pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public float getValor_reserva() {
        return this.valor_reserva;
    }

    public void setValor_reserva(float valor_reserva) {
        this.valor_reserva = valor_reserva;
    }
   

}