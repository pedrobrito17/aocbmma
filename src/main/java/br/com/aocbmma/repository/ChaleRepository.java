package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.Chale;

@Repository
public interface ChaleRepository extends JpaRepository<Chale, Integer>{
    
    public List<Chale> findByDisponivel(boolean disponivel);
}