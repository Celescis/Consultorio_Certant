package com.cisternas.consultorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cisternas.consultorio.model.Turno;


public interface TurnoRepository extends CrudRepository<Turno, Long> {

	List<Turno> findAllByEstado(Turno.EnEstado estado);

	@Query("SELECT t FROM Turno t WHERE t.especialidad.id = :especialidadId AND t.estado = Disponible")
	List<Turno> findAllByEspecialidadId(@Param("especialidadId") Long especialidadId);

	@Query("SELECT t FROM Turno t WHERE t.profesional.id = :profesionalId AND t.estado = Disponible")
	List<Turno> findAllByProfesionalId(@Param("profesionalId") Long profesionalId);

	@Query("SELECT t FROM Turno t WHERE t.paciente.id = :pacienteId AND t.estado = Confirmado")
	List<Turno> findAllByPacienteId(@Param("pacienteId") Long pacienteId);

}
