package br.com.aocbmma.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.ReservaChale;

@Repository
public interface ReservaChaleRepository extends JpaRepository<ReservaChale, Integer>{
    
    @Query(value="select * from reserva_chale where "
        +"(data_entrada between :dt_entrada_pesq and :dt_saida_pesq) OR (data_saida between :dt_entrada_pesq and :dt_saida_pesq) "
        +"and (:dt_entrada_pesq between data_entrada and data_saida) OR (:dt_saida_pesq between data_entrada and data_saida)", nativeQuery=true)
    List<ReservaChale> buscarReservaQueCoincidaComAPesquisada(@Param("dt_entrada_pesq") Date data_entrada, @Param("dt_saida_pesq") Date data_saida);
}