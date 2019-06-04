package br.com.aocbmma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="espaco_cajueiro")
public class EspacoCajueiro{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @Column(precision=4, scale=2)
    @Type(type="float")
    private float precoAtual_diurno;

    @Column(precision=4, scale=2)
    @Type(type="float")
    private float precoAtual_noturno;

    @Column(precision=4, scale=2)
    @Type(type="float")
    private float precoAtual_diaria;

    @Column
    private boolean disponivel;


    public Integer getCod() {
        return this.cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public float getPrecoAtual_diurno() {
        return this.precoAtual_diurno;
    }

    public void setPrecoAtual_diurno(float precoAtual_diurno) {
        this.precoAtual_diurno = precoAtual_diurno;
    }

    public float getPrecoAtual_noturno() {
        return this.precoAtual_noturno;
    }

    public void setPrecoAtual_noturno(float precoAtual_noturno) {
        this.precoAtual_noturno = precoAtual_noturno;
    }

    public float getPrecoAtual_diaria() {
        return this.precoAtual_diaria;
    }

    public void setPrecoAtual_diaria(float precoAtual_diaria) {
        this.precoAtual_diaria = precoAtual_diaria;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}