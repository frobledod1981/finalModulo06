package com.frobledo.service;

import com.frobledo.dto.AlumnoDTO; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List; 
import java.util.Arrays;


@Service
public class AlumnoFrontService {

	@Autowired
	private RestTemplate restTemplate;

	public List<AlumnoDTO> findAll(String jwtToken) {
		String url = "http://localhost:8080/api/alumnos";
		
		HttpHeaders headers = new HttpHeaders(); 
		headers.set("Authorization", "Bearer " + jwtToken);
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<AlumnoDTO[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, AlumnoDTO[].class);
		return Arrays.asList(response.getBody());
	}
	
	

}
