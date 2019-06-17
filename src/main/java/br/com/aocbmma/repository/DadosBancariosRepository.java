package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.DadosBancarios;

@Repository
public interface DadosBancariosRepository extends JpaRepository<DadosBancarios, Integer>{
    
}