package br.com.aocbmma.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.ReservaCampoFutebol;

@Repository
public interface ReservaCampoFutebolRepository extends JpaRepository<ReservaCampoFutebol, Integer>{

    @Query(value="select hour(hora_inicio) from reserva_campo_futebol where data_reserva = :data and pagamento != 'vencido'", nativeQuery=true)
    public List<Integer> selectHoraInicio(@Param("data") Date data);

    @Query(value="select hour(hora_termino) from reserva_campo_futebol where data_reserva = :data and pagamento != 'vencido'", nativeQuery=true)
    public List<Integer> selectHoraTermino(@Param("data") Date data);


}