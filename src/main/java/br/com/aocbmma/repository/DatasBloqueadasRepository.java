package br.com.aocbmma.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.DatasBloqueadas;

@Repository
public interface DatasBloqueadasRepository extends JpaRepository<DatasBloqueadas, Integer>{

	ArrayList<DatasBloqueadas> findAllByOrderByDataDesc();
    
}