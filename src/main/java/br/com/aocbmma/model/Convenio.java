package br.com.aocbmma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="convenios")
public class Convenio{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String nome_empresa;

    @Column(columnDefinition = "longtext")
    @NotNull
    private String beneficio;

    @Column
    @NotNull
    private String path_logo;

    @OneToOne
    private CategoriaConvenio categoria;

    public Convenio() {
    }

    public Convenio(Integer id, String nome_empresa, String beneficio, String path_logo, CategoriaConvenio categoria) {
        this.id = id;
        this.nome_empresa = nome_empresa;
        this.beneficio = beneficio;
        this.path_logo = path_logo;
        this.categoria = categoria;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_empresa() {
        return this.nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getBeneficio() {
        return this.beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public String getPath_logo() {
        return this.path_logo;
    }

    public void setPath_logo(String path_logo) {
        this.path_logo = path_logo;
    }

    public CategoriaConvenio getCategoria() {
        return this.categoria;
    }

    public void setCategoria(CategoriaConvenio categoria) {
        this.categoria = categoria;
    }

}