package br.com.aocbmma.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.ReservaEspacoCajueiro;

@Repository
public interface ReservaEspacoCajueiroRepository extends JpaRepository<ReservaEspacoCajueiro, Integer>{

    @Query(value="SELECT * FROM reserva_cajueiro WHERE pagamento = 'pendente'", nativeQuery=true)
    List<ReservaEspacoCajueiro> selectReservasPendentes();
    
    @Query(value="SELECT data_reserva FROM reserva_cajueiro WHERE data_reserva >= curdate() and pagamento != 'vencido'", nativeQuery=true)
    List<String> findDatasReservasRealizadas();
}