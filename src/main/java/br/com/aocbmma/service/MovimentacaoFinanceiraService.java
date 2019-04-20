package br.com.aocbmma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.MovimentacaoFinanceira;
import br.com.aocbmma.repository.MovimentacaoFinanceiraRepository;

@Service
public class MovimentacaoFinanceiraService{

    @Autowired
    private MovimentacaoFinanceiraRepository repository;

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
        repository.deleteById(id);
    }

}