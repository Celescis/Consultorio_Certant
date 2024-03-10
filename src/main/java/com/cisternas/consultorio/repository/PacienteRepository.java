package com.cisternas.consultorio.repository;

import org.springframework.data.repository.CrudRepository;

import com.cisternas.consultorio.model.Paciente;


public interface PacienteRepository extends CrudRepository<Paciente, Long>{

	Paciente findByCuil(Long cuil);
}
