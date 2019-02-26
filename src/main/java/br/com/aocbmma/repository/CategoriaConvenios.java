package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.CategoriaConvenio;

@Repository
public interface CategoriaConvenios extends JpaRepository<CategoriaConvenio, Integer>{

    CategoriaConvenio findByCategoria(String categoria);
}