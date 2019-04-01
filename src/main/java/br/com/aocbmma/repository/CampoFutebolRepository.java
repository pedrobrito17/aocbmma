package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.CampoFutebol;

@Repository
public interface CampoFutebolRepository extends JpaRepository<CampoFutebol, Integer>{


}