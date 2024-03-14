package com.cisternas.consultorio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cisternas.consultorio.model.Turno;

public interface TurnoRepository extends CrudRepository<Turno, Long>{

	List<Turno> findAllByEstado(Turno.EnEstado estado);
}
