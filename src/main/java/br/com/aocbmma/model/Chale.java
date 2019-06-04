package br.com.aocbmma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="chale")
public class Chale{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @Column(precision=4, scale=2)
    @Type(type="float")
    private float precoAtual;

    @Column
    private boolean disponivel;


    public Integer getCod_chale() {
        return this.cod;
    }

    public void setCod_chale(Integer cod_chale) {
        this.cod = cod_chale;
    }

    public float getprecoAtual() {
        return this.precoAtual;
    }

    public void setprecoAtual(float precoAtual) {
        this.precoAtual = precoAtual;
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