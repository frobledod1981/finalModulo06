package com.frobledo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.frobledo.config.EmailUtil;
import com.frobledo.model.Usuario;
import com.frobledo.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		logger.info("Cargando usuario por nombre de usuario : ", username);
		Usuario user = userRepository.findByUsername(username);
		if (user == null) {
			logger.error(" Usuario no encontrado con el nombre de usuario :", username);
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getEmail(),
				user.getRoles());
	}

	public Usuario save(Usuario usuario) {
		// Encriptar el correo electrónico antes de guardar 
		logger.info("Guardando Usuario :", usuario);
		usuario.setEmail(EmailUtil.encryptEmail(usuario.getEmail()));
		return userRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		 logger.info("Obteniendo todos los usuarios");
		return userRepository.findAll();
	}
	
	// Metodo para encriptar contraseñas existentes 
	public void encryptExistingEmails() { 
		logger.info("Encriptando emails existentes");
		List<Usuario> usuarios = userRepository.findAll(); 
		for (Usuario usuario : usuarios) { 
			String encryptedPassword = EmailUtil.encryptEmail(usuario.getEmail());
			usuario.setEmail(encryptedPassword); 
			userRepository.save(usuario); 
		}
	}
}
