package br.com.aocbmma.service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.helper.FileUpload;
import br.com.aocbmma.model.MovimentacaoFinanceira;
import br.com.aocbmma.repository.MovimentacaoFinanceiraRepository;

@Service
public class MovimentacaoFinanceiraService{

    @Autowired
    private MovimentacaoFinanceiraRepository repository;

    @Autowired
    private ServletContext servlet;

    public boolean salvarMovimentacaoFinanceira(MovimentacaoFinanceira financeiro){
        if(repository.save(financeiro) != null){
            return true;
        }else{
            return false;
        }
    }

    public List<MovimentacaoFinanceira> getTodasMovimentacoesFinanceiras(){
        return repository.getTodasMovimentacoes();
    }

    public void deletarFinanceiro(int id){
        deletarArquivo(id);
        repository.deleteById(id);
    }

    public void deletarArquivo(Integer id){
		String pathRoot = servlet.getRealPath("/");
		MovimentacaoFinanceira financeira = repository.getOne(id);
		String pathFile = financeira.getPath_arquivo();
		FileUpload.deleteFile(pathRoot, pathFile);
	}

}