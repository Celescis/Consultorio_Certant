package com.cisternas.consultorio.dto;

import java.util.List;

public class AgendaDTO {

	private Long id;
	private ProfesionalDTO profesional;
	private List<TurnoDTO> turnos;

	public AgendaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgendaDTO(Long id, ProfesionalDTO profesional, List<TurnoDTO> turnos) {
		super();
		this.id = id;
		this.profesional = profesional;
		this.turnos = turnos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProfesionalDTO getProfesional() {
		return profesional;
	}

	public void setProfesional(ProfesionalDTO profesional) {
		this.profesional = profesional;
	}

	public List<TurnoDTO> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<TurnoDTO> turnos) {
		this.turnos = turnos;
	}

}
