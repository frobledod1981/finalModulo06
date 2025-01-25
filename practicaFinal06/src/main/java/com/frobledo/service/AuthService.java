package com.frobledo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.frobledo.dto.UsuarioDTO;

@Service
public class AuthService {

	@Autowired
	private RestTemplate restTemplate;

	public String signin(UsuarioDTO user) {
		String url = "http://localhost:8080/auth/signin";
		return restTemplate.postForObject(url, user, String.class);
	}

}
