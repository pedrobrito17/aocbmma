package br.com.aocbmma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chale")
public class Chale{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @Column
    private float valor;

    @Column
    private boolean disponivel;


    public Integer getCod_chale() {
        return this.cod;
    }

    public void setCod_chale(Integer cod_chale) {
        this.cod = cod_chale;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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