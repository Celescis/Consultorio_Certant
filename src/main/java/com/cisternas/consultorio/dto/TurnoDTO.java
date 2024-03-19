package com.cisternas.consultorio.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cisternas.consultorio.model.Profesional;
import com.cisternas.consultorio.model.Turno.EnEstado;

public class TurnoDTO {

	private Long id;
	private LocalDate fecha;
	private LocalTime hora;
	private EnEstado estado;
	private ConsultorioDTO consultorio;
	private PacienteDTO paciente;
	private EspecialidadDTO especialidad;
	private Long profesionalId;;

	public TurnoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public EnEstado getEstado() {
		return estado;
	}

	public void setEstado(EnEstado estado) {
		this.estado = estado;
	}

	public ConsultorioDTO getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(ConsultorioDTO consultorio) {
		this.consultorio = consultorio;
	}

	public PacienteDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
	}

	public EspecialidadDTO getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadDTO especialidad) {
		this.especialidad = especialidad;
	}

	public Long getProfesionalId() {
		return profesionalId;
	}

	public void setProfesionalId(Long profesionalId) {
		this.profesionalId = profesionalId;
	}

}
