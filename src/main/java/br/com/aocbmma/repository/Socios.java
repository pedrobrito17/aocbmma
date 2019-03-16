package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Socio;

@Repository
public interface Socios extends JpaRepository<Socio,Integer>{

}