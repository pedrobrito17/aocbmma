package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Integer>{
    
}