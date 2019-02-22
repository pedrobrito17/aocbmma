package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Convenio;

@Repository
public interface Convenios extends JpaRepository<Convenio, Integer>{
    
    public List<Convenio> findAllByOrderByIdDesc();
}