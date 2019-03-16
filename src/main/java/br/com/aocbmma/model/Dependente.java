package br.com.aocbmma.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="dependente")
public class Dependente{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String parentesco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "socio_id", referencedColumnName = "id")
    private Socio socio;

    public Dependente() {
    }

    public Dependente(Integer id, String nome, String parentesco, Socio socio) {
        this.id = id;
        this.nome = nome;
        this.parentesco = parentesco;
        this.socio = socio;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return this.parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Socio getSocio() {
        return this.socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

}