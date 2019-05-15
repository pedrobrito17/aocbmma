package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.SocioTransferencia;

@Repository
public interface SocioTransferenciaRepository extends JpaRepository<SocioTransferencia, Integer>{

	SocioTransferencia findBySocio(Socio socio);

}