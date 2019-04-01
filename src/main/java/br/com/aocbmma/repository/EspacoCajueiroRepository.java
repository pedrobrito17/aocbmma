package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.EspacoCajueiro;

@Repository
public interface EspacoCajueiroRepository extends JpaRepository<EspacoCajueiro, Integer>{
    
}