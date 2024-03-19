package com.cisternas.consultorio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "sys_profesional")
public class Profesional implements Serializable {

	@Id
	@NotNull(message = "Debe ingresar la matricula")
	@Column(name = "pro_matricula", unique = true)
	private Long matricula;

	@NotBlank(message = "Debe ingresar el nombre")
	@Column(name = "pro_nombre")
	private String nombre;

	@NotBlank(message = "Debe ingresar el apellido")
	@Column(name = "pro_apellido")
	private String apellido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "esp_id")
	private Especialidad especialidad;

	@OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL)
	private List<Disponibilidad> disponibilidad;
	
	@OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL)
	private List<Turno> turnos;

	public Profesional() {
		super();
		this.disponibilidad = new ArrayList<>();
		this.turnos = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
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

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public List<Disponibilidad> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(List<Disponibilidad> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	

}
