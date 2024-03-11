package com.cisternas.consultorio.dto;

import java.util.List;

public class ProfesionalDTO {

	private Long matricula;
	private EspecialidadDTO especialidad;
	private String nombre;
	private String apellido;
	private AgendaDTO agenda;
	private List<DisponibilidadDTO> disponibilidad;

	public ProfesionalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProfesionalDTO(Long matricula, EspecialidadDTO especialidad, String nombre, String apellido, AgendaDTO agenda,
			List<DisponibilidadDTO> disponibilidad) {
		super();
		this.matricula = matricula;
		this.especialidad = especialidad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.agenda = agenda;
		this.disponibilidad = disponibilidad;
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

	public AgendaDTO getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaDTO agenda) {
		this.agenda = agenda;
	}

	public List<DisponibilidadDTO> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(List<DisponibilidadDTO> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "ProfesionalDTO [matricula=" + matricula + ", especialidad=" + especialidad + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", agenda=" + agenda + ", disponibilidad=" + disponibilidad + "]";
	}

}
