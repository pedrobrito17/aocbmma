package br.com.aocbmma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.CategoriaConvenio;
import br.com.aocbmma.repository.CategoriaConvenios;

@Service
public class CategoriaConvenioService{

    @Autowired
    private CategoriaConvenios categoriaConvenios;

    public List<CategoriaConvenio> getListCategoriaConvenios(){
        return categoriaConvenios.findAll();
    }

    public CategoriaConvenio getCategoriaConvenio(Integer id){
        return categoriaConvenios.findById(id).get();
    }
}