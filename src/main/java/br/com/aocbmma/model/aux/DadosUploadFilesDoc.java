package br.com.aocbmma.model.aux;

import java.io.Serializable;

public class DadosUploadFilesDoc implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;

    private int socioid;

    private String path;

    private String name;

    private long tamanho;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSocioid() {
        return this.socioid;
    }

    public void setSocioid(int socioid) {
        this.socioid = socioid;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }


}