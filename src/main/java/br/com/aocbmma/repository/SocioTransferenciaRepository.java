package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.SocioTransferencia;

@Repository
public interface SocioTransferenciaRepository extends JpaRepository<SocioTransferencia, Integer>{

	SocioTransferencia findBySocio(Socio socio);

	@Query(value="SELECT * FROM socio_transferencia WHERE cod NOT IN "+
					"(SELECT socio_cod FROM pagamento_mensalidade WHERE MONTH(data_mensalidade) = :mes_ultima_mensalidade)", nativeQuery=true)
	List<SocioTransferencia> getSociosComMensalidadesAtrasadas(@Param("mes_ultima_mensalidade") int mes);
	

}