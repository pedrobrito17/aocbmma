package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Noticia;

@Repository
public interface Noticias extends JpaRepository<Noticia, Integer>{

    public List<Noticia> findAllByOrderByIdDesc();

    @Query(value="SELECT * FROM noticias ORDER BY ID DESC LIMIT 1", nativeQuery=true)
    public Noticia findUltimoRegistro();

    @Query(value="select * from noticias order by id desc limit 3", nativeQuery=true)
    public List<Noticia> findUltimasNoticias();

    @Query(value="select * from noticias where titulo like %:busca% ORDER BY id DESC", nativeQuery=true)
    public List<Noticia> findAllByNoticiaLike(@Param("busca") String busca);
    
}