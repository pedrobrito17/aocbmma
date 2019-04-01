package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.ReservaEspacoCajueiro;

@Repository
public interface ReservaEspacoCajueiroRepository extends JpaRepository<ReservaEspacoCajueiro, Integer>{

    @Query(value="SELECT * FROM reserva_cajueiro WHERE pagamento = 'pendente'", nativeQuery=true)
    List<ReservaEspacoCajueiro> selectReservasPendentes();
    
    @Query(value="SELECT data_reserva FROM reserva_cajueiro WHERE data_reserva >= curdate() and pagamento != 'vencido'", nativeQuery=true)
    List<String> findDatasReservasRealizadas();

    @Query(value="select * from reserva_cajueiro r inner join socio s on r.socio_id = s.id where s.id = :id order by r.data_reserva desc", nativeQuery=true)
    List<ReservaEspacoCajueiro> findBySocio(@Param("id") int id);

    @Query(value="select * from reserva_cajueiro r where r.pagamento!='vencido' order by r.data_reserva desc", nativeQuery=true)
    List<ReservaEspacoCajueiro> findAllDiferenteDePagamentoVencido();
}