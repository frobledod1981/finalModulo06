package com.frobledo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frobledo.model.Materia;
import com.frobledo.service.MateriaService;

@RestController
@RequestMapping("/materias")
public class MateriasController {
	
	@Autowired
    private MateriaService materiaService;

    @PostMapping
    public Materia save(@RequestBody Materia materia) {
        return materiaService.save(materia);
    }

}
