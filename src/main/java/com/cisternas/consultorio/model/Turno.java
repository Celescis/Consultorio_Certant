package com.cisternas.consultorio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "sys_turno")
public class Turno implements Serializable {
	public enum EnEstado {
		Confirmado, Cancelado, Modificado, Disponible
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tur_id")
	private Long id;

	@NotNull(message = "Debe ingresar la fecha")
	@FutureOrPresent(message = "La fecha debe ser hoy o mas adelante")
	@Column(name = "tur_fecha")
	private LocalDate fecha;

	@NotNull(message = "Debe ingresar el horario")
	@Column(name = "tur_hora")
	private LocalTime hora;

	@Column(name = "tur_estado")
	private EnEstado estado;

	@ManyToOne
	@JoinColumn(name = "tur_consultorio")
	private Consultorio consultorio;

	@ManyToOne
	@JoinColumn(name = "tur_paciente")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "tur_especialidad")
	private Especialidad especialidad;

	@ManyToOne
	@JoinColumn(name = "tur_profesional")
	private Profesional profesional;

	public Turno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public EnEstado getEstado() {
		return estado;
	}

	public void setEstado(EnEstado estado) {
		this.estado = estado;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

}
