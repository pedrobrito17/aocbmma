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

    @Query(value="select * from reserva_campo_futebol where pagamento = 'pendente'", nativeQuery=true)
    public List<ReservaCampoFutebol> selectReservaCampoSolicitada();

    @Query(value="select * from reserva_campo_futebol r inner join socio s on r.socio_id = s.id where s.id = :id order by r.data_reserva desc", nativeQuery=true)
    List<ReservaCampoFutebol> findBySocio(@Param("id") int id);

    @Query(value="select * from reserva_campo_futebol r order by r.data_reserva desc", nativeQuery=true)
    List<ReservaCampoFutebol> findAllOrd();

    @Query(value="SELECT * FROM reserva_campo_futebol WHERE pagamento='pendente' AND DATE_ADD(data_solicitacao, INTERVAL 3 DAY) <= CURDATE()", nativeQuery=true)
    List<ReservaCampoFutebol> findReservasPagamentoVencido();


}