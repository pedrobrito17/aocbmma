package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.DadosContato;
import br.com.aocbmma.model.Socio;

@Repository
public interface Socios extends JpaRepository<Socio,Integer>{

    List<Socio> findBySituacao(String situacao);

    @Query(value="SELECT * FROM socio s INNER JOIN dados_oficial d ON s.id = d.socio_id WHERE s.situacao='ativo' AND month(s.data_nascimento) = :mes order by day(s.data_nascimento) asc", nativeQuery=true)
    List<Socio> getAniversariantes(@Param("mes") int mes);

    Socio findByDadosContato(DadosContato dadosContato);

    @Query(value="select * from socio where tipo_socio=:categoria order by nome asc", nativeQuery=true)
    List<Socio> findByTipoSocio(@Param("categoria") String categoria);

    @Query(value="select * from socio where situacao='ativo' AND tipo_socio=:categoria order by nome asc", nativeQuery=true)
    List<Socio> findByTipoSocioAtivo(@Param("categoria") String categoria);
    
    @Query(value="select nome from socio", nativeQuery=true)
	List<String> findAllNomesSocios();

	Socio findByNome(String nomeSocio);

}