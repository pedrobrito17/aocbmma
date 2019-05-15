package br.com.aocbmma.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.PagamentoMensalidade;

@Repository
public interface PagamentoMensalidadeRepository extends JpaRepository<PagamentoMensalidade, Integer>{

	@Query(value="SELECT * FROM pagamento_mensalidade WHERE socio_cod = :socio_cod AND data_mensalidade = :data_mensalidade", nativeQuery=true)
	PagamentoMensalidade findBySocioAndDataPagamento(@Param("socio_cod") int socio_cod, @Param("data_mensalidade") Date data_mensalidade);



}