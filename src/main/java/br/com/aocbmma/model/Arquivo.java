package br.com.aocbmma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arquivo")
public class Arquivo{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome_arquivo;

    @Column
    private String path;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_arquivo() {
        return this.nome_arquivo;
    }

    public void setNome_arquivo(String nome_arquivo) {
        this.nome_arquivo = nome_arquivo;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}