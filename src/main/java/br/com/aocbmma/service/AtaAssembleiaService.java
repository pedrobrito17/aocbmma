package br.com.aocbmma.service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.helper.FileUpload;
import br.com.aocbmma.model.AtaAssembleia;
import br.com.aocbmma.repository.AtaAssembleiaRepository;

@Service
public class AtaAssembleiaService{

    @Autowired
	private AtaAssembleiaRepository repository;
	
	@Autowired
    private ServletContext servlet;

	public boolean salvarAtaAssembleia(AtaAssembleia ataAssembleia) {
		if( (repository.save(ataAssembleia) != null) ){
            return true;
        }
        else{
            return false;
        }
	}

	public List<AtaAssembleia> getTodasAtasAssembleia() {
		return repository.findAll();
	}

	public void deletarAtaAssembleia(Integer id) {
		deletarArquivo(id);
		repository.deleteById(id);
	}

	public void deletarArquivo(Integer id){
		String pathRoot = servlet.getRealPath("/");
		AtaAssembleia ata = repository.getOne(id);
		String pathFile = ata.getPath_ata();
		FileUpload.deleteFile(pathRoot, pathFile);
	}


}