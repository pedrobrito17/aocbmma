package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import br.com.aocbmma.model.DadosContato;

@Repository
public interface DadosContatoRepository extends JpaRepository<DadosContato, Integer>{

	@Nullable
	DadosContato findByEmail(String email);
    
}