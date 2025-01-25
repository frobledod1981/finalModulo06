package com.frobledo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frobledo.model.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>{

}
