package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.MovimentacaoFinanceira;

@Repository
public interface MovimentacaoFinanceiraRepository extends JpaRepository<MovimentacaoFinanceira, Integer>{

    @Query(value="SELECT * FROM movimentacao_financeira order by periodo_inicial desc", nativeQuery=true)
    public List<MovimentacaoFinanceira> getTodasMovimentacoes();
    
}