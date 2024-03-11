package com.cisternas.consultorio.dto;

public class EspecialidadDTO {

	private Long id;
	private String descripcion;

	public EspecialidadDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EspecialidadDTO(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
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

	@Override
	public String toString() {
		return "EspecialidadDTO [id=" + id + ", descripcion=" + descripcion + "]";
	}

}
