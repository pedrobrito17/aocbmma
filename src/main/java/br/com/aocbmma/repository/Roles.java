package br.com.aocbmma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.aocbmma.model.Role;

public interface Roles extends JpaRepository<Role, Integer>{

    Role findByRole(String role);
    
}