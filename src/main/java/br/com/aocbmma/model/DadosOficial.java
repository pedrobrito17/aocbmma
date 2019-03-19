package br.com.aocbmma.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dados_oficial")
public class DadosOficial{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String nome_guerra;

    @Column
    @NotNull
    private String posto;

    @Column
    private String quadro;

    @Column
    @NotNull
    private String corporacao;

    @Column
    @NotNull
    private String lotacao;

    @Column
    @NotNull
    private String rg_militar;

    @Column
    @NotNull
    private String matricula;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "socio_id", nullable = false)
    private Socio socio;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_guerra() {
        return this.nome_guerra;
    }

    public void setNome_guerra(String nome_guerra) {
        this.nome_guerra = nome_guerra;
    }

    public String getPosto() {
        return this.posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String getQuadro() {
        return this.quadro;
    }

    public void setQuadro(String quadro) {
        this.quadro = quadro;
    }

    public String getCorporacao() {
        return this.corporacao;
    }

    public void setCorporacao(String corporacao) {
        this.corporacao = corporacao;
    }

    public String getLotacao() {
        return this.lotacao;
    }

    public void setLotacao(String lotacao) {
        this.lotacao = lotacao;
    }

    public String getRg_militar() {
        return this.rg_militar;
    }

    public void setRg_militar(String rg_militar) {
        this.rg_militar = rg_militar;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Socio getSocio() {
        return this.socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

}