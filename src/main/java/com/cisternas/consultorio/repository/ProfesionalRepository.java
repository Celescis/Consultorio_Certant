package com.cisternas.consultorio.repository;

import org.springframework.data.repository.CrudRepository;

import com.cisternas.consultorio.model.Profesional;

public interface ProfesionalRepository extends CrudRepository<Profesional, Long>{

	Profesional findByMatricula(Long matricula);
}
