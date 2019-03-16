package br.com.aocbmma.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.Dependente;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.repository.Socios;

@Service
public class SocioService{

    @Autowired
    private Socios socios;

    @Transactional
    public void salvarSocio(Socio socio){
        verificarCadastroDependentes(socio.getDependentes());
        relacionarEntidadePaiComEntidadeFilha(socio);
        socios.save(socio);
    }

    public void relacionarEntidadePaiComEntidadeFilha(Socio socio){
        socio.getDadosBancarios().setSocio(socio);
        socio.getDadosContato().setSocio(socio);
        socio.getDadosOficial().setSocio(socio);
        
        List<Dependente> dependentes = socio.getDependentes();
        relacionarEntidadePaiComOsSeusDependentes(dependentes, socio);
    }

    public void verificarCadastroDependentes(List<Dependente> socioDependentes){
        for(int i = 0 ; i < socioDependentes.size() ; i++){
            if (socioDependentes.get(i).getNome().isEmpty() || socioDependentes.get(i).getParentesco().isEmpty()) {
                socioDependentes.remove(i);
            }
        }
        if(socioDependentes.isEmpty()){
            socioDependentes = null;
        }
    }

    public void relacionarEntidadePaiComOsSeusDependentes(List<Dependente> socioDependentes, Socio socio){
        if(socioDependentes != null){
            for(int i = 0 ; i < socioDependentes.size() ; i++){
                socioDependentes.get(i).setSocio(socio);            
            }
        }
    }

}