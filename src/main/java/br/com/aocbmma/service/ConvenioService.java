package br.com.aocbmma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.Convenio;
import br.com.aocbmma.repository.Convenios;

@Service
public class ConvenioService{

    @Autowired
    private Convenios convenios;

    public boolean salvarConvenio(Convenio convenio){
        if(convenios.save(convenio) != null){
            return true;
        }
        else{
            return false;
        }
    }

    public java.util.List<Convenio> getConvenios(){
        return convenios.findAllByOrderByIdDesc();
    }

    public void deletarConvenio(Integer id){
        convenios.deleteById(id);
    }

    public Convenio buscarConvenio(Integer id){
        return convenios.findById(id).get();
    }


}