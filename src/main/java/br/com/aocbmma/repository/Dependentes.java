package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Dependente;

@Repository
public interface Dependentes extends JpaRepository<Dependente,Integer>{

}