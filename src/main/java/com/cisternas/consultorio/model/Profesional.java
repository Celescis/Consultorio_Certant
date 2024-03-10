package com.cisternas.consultorio.model;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

	@OneToOne(mappedBy = "profesional", cascade = CascadeType.ALL)
	private Especialidad especialidad;

	@OneToOne(mappedBy = "profesional", cascade = CascadeType.ALL)
	private Agenda agenda;

	@OneToMany(mappedBy = "profesional", cascade = CascadeType.ALL)
	private Set<Disponibilidad> disponibilidad;

	public Profesional() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesional(@NotNull(message = "Debe ingresar la matricula") Long matricula,
			@NotBlank(message = "Debe ingresar el nombre") String nombre,
			@NotBlank(message = "Debe ingresar el apellido") String apellido, Especialidad especialidad, Agenda agenda,
			Set<Disponibilidad> disponibilidad) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.agenda = agenda;
		this.disponibilidad = disponibilidad;
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

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Set<Disponibilidad> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Set<Disponibilidad> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Profesional [matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", especialidad=" + especialidad + ", agenda=" + agenda + ", disponibilidad=" + disponibilidad + "]";
	}

}