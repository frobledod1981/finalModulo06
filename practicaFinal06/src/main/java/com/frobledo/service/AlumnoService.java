package com.frobledo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frobledo.model.Alumno;
import com.frobledo.repository.AlumnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AlumnoService {
	
	private static final Logger logger = LoggerFactory.getLogger(AlumnoService.class);
	
	 @Autowired
	    private AlumnoRepository alumnoRepository;

	    public Alumno save(Alumno alumno) {
	    	logger.info("Guardando alumno :", alumno);
	        return alumnoRepository.save(alumno);
	    }

	    public List<Alumno> findAll() {
	        return alumnoRepository.findAll();
	    }

}
