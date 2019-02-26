package br.com.aocbmma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.Noticia;
import br.com.aocbmma.repository.Noticias;

@Service
public class NoticiaService{

    @Autowired
    private Noticias noticias;

    public boolean salvarNoticia(Noticia noticia){
        if(noticias.save(noticia) != null){
            return true;
        }
        else{
            return false;
        }
    }

    public List<Noticia> getNoticias(){
        return noticias.findAllByOrderByIdDesc();
    }

    public void deletarNoticia(Integer id){
        noticias.deleteById(id);
    }

    public Noticia buscarNoticia(Integer id){
        return noticias.findById(id).get();
    }

    public Noticia getNoticiaPrincipal(){
        return noticias.findUltimoRegistro();
    }

    public List<Noticia> getUltimasTresNoticias(){
        List<Noticia> ultimasNoticias = noticias.findUltimasNoticias();
        ultimasNoticias.remove(0);
        return ultimasNoticias;
    }

    public List<Noticia> buscarNoticias(String busca){
        return noticias.findAllByNoticiaLike(busca);
    }

}