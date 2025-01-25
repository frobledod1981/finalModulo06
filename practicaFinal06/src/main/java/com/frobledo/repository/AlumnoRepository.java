package com.frobledo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frobledo.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
