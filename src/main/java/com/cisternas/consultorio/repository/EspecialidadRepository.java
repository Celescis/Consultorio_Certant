package com.cisternas.consultorio.repository;

import org.springframework.data.repository.CrudRepository;

import com.cisternas.consultorio.model.Especialidad;

public interface EspecialidadRepository extends CrudRepository<Especialidad, Long> {

	Especialidad findByDescripcion(String descripcion);
}
