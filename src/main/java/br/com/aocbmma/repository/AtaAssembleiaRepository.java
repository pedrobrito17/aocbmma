package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.AtaAssembleia;

@Repository
public interface AtaAssembleiaRepository extends JpaRepository<AtaAssembleia, Integer>{
    
}