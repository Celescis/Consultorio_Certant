package com.cisternas.consultorio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "tur_agenda")
	private Agenda agenda;

	@Column(name = "tur_estado")
	private EnEstado estado;

	@ManyToOne
	@JoinColumn(name = "tur_consultorio")
	private Consultorio consultorio;

	@ManyToOne
	@JoinColumn(name = "tur_paciente")
	private Paciente paciente;

	public Turno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turno(Long id, @NotBlank(message = "Debe ingresar la fecha") LocalDate fecha,
			@NotBlank(message = "Debe ingresar el horario") LocalTime hora, Agenda agenda, boolean reservado,
			EnEstado estado, Consultorio consultorio, Paciente paciente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.agenda = agenda;
		this.estado = estado;
		this.consultorio = consultorio;
		this.paciente = paciente;
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

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
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

}
