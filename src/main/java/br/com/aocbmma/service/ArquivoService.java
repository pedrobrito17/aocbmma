package br.com.aocbmma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.Arquivo;
import br.com.aocbmma.repository.ArquivoRepository;

@Service
public class ArquivoService{

    @Autowired
    private ArquivoRepository arquivoRepository;

    public boolean salvarArquivo(Arquivo arquivo){
        if(arquivoRepository.save(arquivo)!=null){
            return true;
        }else{
            return false;
        }
    }

	public List<Arquivo> getArquivos() {
		return arquivoRepository.findAll();
	}

	public void deletarArquivo(int id) {
        arquivoRepository.deleteById(id);
	}

}