package com.frobledo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.frobledo.model.Materia;
import com.frobledo.repository.MateriaRepository;

@Service
public class MateriaService {
	
	private static final Logger logger = LoggerFactory.getLogger(MateriaService.class);
	
	@Autowired
    private MateriaRepository materiaRepository;

    public Materia save(Materia materia) {
    	logger.info("Guardando Materia: ", materia);
        return materiaRepository.save(materia);
    }

}
