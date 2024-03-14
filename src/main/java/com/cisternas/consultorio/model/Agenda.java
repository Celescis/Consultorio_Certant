package com.cisternas.consultorio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sys_agenda")
public class Agenda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "age_id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "age_profesional")
	private Profesional profesional;

	@OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL)
	private List<Turno> turnos;

	public Agenda() {
		super();
		this.turnos = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public Agenda(Long id, Profesional profesional, List<Turno> turnos) {
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

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", profesional=" + profesional + ", turnos=" + turnos + "]";
	}

}
