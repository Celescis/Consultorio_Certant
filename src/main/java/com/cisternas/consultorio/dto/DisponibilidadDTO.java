package com.cisternas.consultorio.dto;

import java.time.LocalTime;
import java.util.Objects;

public class DisponibilidadDTO {

	private Long id;
	private String dia;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private ProfesionalDTO profesional;

	public DisponibilidadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DisponibilidadDTO(Long id, String dia, LocalTime horaInicio, LocalTime horaFin, ProfesionalDTO profesional) {
		super();
		this.id = id;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.profesional = profesional;
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

	public ProfesionalDTO getProfesional() {
		return profesional;
	}

	public void setProfesional(ProfesionalDTO profesional) {
		this.profesional = profesional;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, horaFin, horaInicio, id, profesional);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		DisponibilidadDTO other = (DisponibilidadDTO) obj;
		return Objects.equals(dia, other.dia) && Objects.equals(horaFin, other.horaFin)
				&& Objects.equals(horaInicio, other.horaInicio) && Objects.equals(id, other.id)
				&& Objects.equals(profesional, other.profesional);
	}

	@Override
	public String toString() {
		return "DisponibilidadDTO [id=" + id + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin
				+ ", profesional=" + profesional + "]";
	}

}
