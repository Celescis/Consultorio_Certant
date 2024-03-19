package com.cisternas.consultorio.dto;

import java.util.List;

public class ProfesionalDTO {

	private Long matricula;
	private EspecialidadDTO especialidad;
	private String nombre;
	private String apellido;
	private List<DisponibilidadDTO> disponibilidad;
	private List<TurnoDTO> turnos;

	public ProfesionalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public EspecialidadDTO getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(EspecialidadDTO especialidad) {
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<DisponibilidadDTO> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(List<DisponibilidadDTO> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public List<TurnoDTO> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<TurnoDTO> turnos) {
		this.turnos = turnos;
	}

}
