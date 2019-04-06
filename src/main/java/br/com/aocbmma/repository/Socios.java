package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Socio;

@Repository
public interface Socios extends JpaRepository<Socio,Integer>{

    List<Socio> findBySituacao(String situacao);

    @Query(value="SELECT * FROM socio s INNER JOIN dados_oficial d ON s.id = d.socio_id WHERE month(s.data_nascimento) = :mes order by s.data_nascimento asc", nativeQuery=true)
    List<Socio> getAniversariantes(@Param("mes") int mes);

    @Query(value="SELECT * FROM dados_contato d INNER JOIN socio s ON s.id = d.socio_id WHERE d.email = :email", nativeQuery=true)
    Socio findByEmail(@Param("email") String email);

    @Query(value="select * from socio where tipo_socio=:categoria order by nome asc", nativeQuery=true)
    List<Socio> findByTipoSocio(@Param("categoria") String categoria);

}