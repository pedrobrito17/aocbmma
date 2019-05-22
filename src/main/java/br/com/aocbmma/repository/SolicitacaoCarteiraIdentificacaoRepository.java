package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.SolicitacaoCarteiraIdentificacao;

@Repository
public interface SolicitacaoCarteiraIdentificacaoRepository extends JpaRepository<SolicitacaoCarteiraIdentificacao, Integer>{

	List<SolicitacaoCarteiraIdentificacao> findByStatus(String status);
    
}