package br.com.aocbmma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.AtaAssembleia;

@Repository
public interface AtaAssembleiaRepository extends JpaRepository<AtaAssembleia, Integer>{

    @Query(value="SELECT * FROM ata_assembleia ORDER BY data_assembleia DESC", nativeQuery=true)
    List<AtaAssembleia> findAllOrderByDataDesc();
    
}