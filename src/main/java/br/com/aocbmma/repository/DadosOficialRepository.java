package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.DadosOficial;

@Repository
public interface DadosOficialRepository extends JpaRepository<DadosOficial, Integer>{
    
}