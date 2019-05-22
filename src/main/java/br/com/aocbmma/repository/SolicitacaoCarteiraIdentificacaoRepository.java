package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.SolicitacaoCarteiraIdentificacao;

@Repository
public interface SolicitacaoCarteiraIdentificacaoRepository extends JpaRepository<SolicitacaoCarteiraIdentificacao, Integer>{

	List<SolicitacaoCarteiraIdentificacao> findByStatus(String status);

	List<SolicitacaoCarteiraIdentificacao> findBySocio(Socio socioLogado);

	@Query(value="SELECT * FROM solicitacao_carteira_identificacao WHERE socio_id = :cod ORDER BY data_solicitacao DESC", nativeQuery=true)
	List<SolicitacaoCarteiraIdentificacao> findBySocioOrderByDataSolicitacaoDesc(@Param("cod") int id);
	
	@Query(value="SELECT * FROM solicitacao_carteira_identificacao ORDER BY data_solicitacao DESC", nativeQuery=true)
	List<SolicitacaoCarteiraIdentificacao> findAllOrderByDataSolicitacaoDesc();
}