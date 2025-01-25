package com.frobledo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frobledo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByUsername(String username);

}
