package br.com.aocbmma.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.PagamentoMensalidade;

@Repository
public interface PagamentoMensalidadeRepository extends JpaRepository<PagamentoMensalidade, Integer>{

	@Query(value="SELECT * FROM pagamento_mensalidade WHERE socio_cod = :socio_cod AND data_mensalidade = :data_mensalidade", nativeQuery=true)
	PagamentoMensalidade findBySocioAndDataMensalidade(@Param("socio_cod") int socio_cod, @Param("data_mensalidade") Date data_mensalidade);
	
	@Query(value="SELECT * FROM pagamento_mensalidade WHERE socio_cod = :socio_cod AND data_pagamento IS NULL ORDER BY data_mensalidade ASC", nativeQuery=true)
	List<PagamentoMensalidade> getInadimplenciaDoSocio(@Param("socio_cod") int cod);
	
	@Query(value="SELECT * FROM pagamento_mensalidade WHERE socio_cod = :socio_cod LIMIT 1", nativeQuery=true)
	List<PagamentoMensalidade> getAdimplenciaDoSocio(@Param("socio_cod") int cod);;
	
	@Query(value="SELECT * FROM pagamento_mensalidade WHERE socio_cod = :socio_cod ORDER BY data_mensalidade DESC", nativeQuery=true)
	List<PagamentoMensalidade> findBySocioOrderByDataPagamentoDesc(@Param("socio_cod") int cod);
	
	@Query(value="SELECT * FROM pagamento_mensalidade "+
					"WHERE MONTH(data_mensalidade) = :mes_ultima_mensalidade LIMIT 1", nativeQuery=true)
	PagamentoMensalidade getPagamentoMensalidadeDoUltimoMes(@Param("mes_ultima_mensalidade") int mes);

	@Query(value="SELECT * FROM pagamento_mensalidade WHERE data_pagamento IS NULL", nativeQuery = true)
	List<PagamentoMensalidade> getMensalidadesSemPagamento();
	
}