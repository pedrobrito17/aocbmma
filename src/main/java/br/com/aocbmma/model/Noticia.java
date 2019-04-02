package br.com.aocbmma.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="noticias")
public class Noticia{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String titulo;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date data_postagem;

    // @Column
    // @NotNull
    // @Lob
    // private byte[] imagem;

    @Column
    @NotNull
    private String imagem;

    @Column(columnDefinition = "longtext")
    @NotNull
    private String noticia;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData_postagem() {
        return this.data_postagem;
    }

    public void setData_postagem(Date data_postagem) {
        this.data_postagem = data_postagem;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNoticia() {
        return this.noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    // public String generateBase64Image(){
    //     return Base64.encodeBase64String(this.getImagem());
    // }

}