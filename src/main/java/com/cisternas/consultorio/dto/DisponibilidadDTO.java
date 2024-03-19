package com.cisternas.consultorio.dto;

import java.time.LocalTime;

public class DisponibilidadDTO {

	private Long id;
	private String dia;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private ProfesionalDTO profesionalDTO;

	public DisponibilidadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisponibilidadDTO(Long id, String dia, LocalTime horaInicio, LocalTime horaFin,
			ProfesionalDTO profesionalDTO) {
		super();
		this.id = id;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.profesionalDTO = profesionalDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public ProfesionalDTO getProfesionalDTO() {
		return profesionalDTO;
	}

	public void setProfesionalDTO(ProfesionalDTO profesionalDTO) {
		this.profesionalDTO = profesionalDTO;
	}

}
