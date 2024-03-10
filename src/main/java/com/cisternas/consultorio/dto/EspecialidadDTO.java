package com.cisternas.consultorio.dto;

import com.cisternas.consultorio.model.Profesional;

public class EspecialidadDTO {

	private Long id;
	private String descripcion;
	private Profesional profesional;

	public EspecialidadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EspecialidadDTO(Long id, String descripcion, Profesional profesional) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.profesional = profesional;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	@Override
	public String toString() {
		return "EspecialidadDTO [id=" + id + ", descripcion=" + descripcion + ", profesional=" + profesional + "]";
	}

}
