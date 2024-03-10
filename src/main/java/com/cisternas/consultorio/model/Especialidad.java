package com.cisternas.consultorio.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "sys_especialidad")
public class Especialidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "esp_id")
	private Long id;

	@NotBlank(message = "Debe ingresar la especialidad")
	@Column(name = "esp_descripcion")
	private String descripcion;

	@OneToOne
	@JoinColumn(name = "esp_profesional")
	private Profesional profesional;

	public Especialidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Especialidad(Long id, @NotBlank(message = "Debe ingresar la especialidad") String descripcion,
			Profesional profesional) {
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
		return "Especialidad [id=" + id + ", descripcion=" + descripcion + ", profesional=" + profesional + "]";
	}

}
