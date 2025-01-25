package com.frobledo.config;

import com.frobledo.service.UsuarioService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 
import jakarta.annotation.PostConstruct; 

@Component
public class DataInitializer {
	
	@Autowired 
	private UsuarioService usuarioService;
	
	// Encriptar contraseñas existentes
	@PostConstruct 
	public void init() {  
		usuarioService.encryptExistingEmails();
	}

}
