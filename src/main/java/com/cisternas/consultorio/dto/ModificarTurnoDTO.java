package com.cisternas.consultorio.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cisternas.consultorio.model.Turno.EnEstado;

public class ModificarTurnoDTO {
	private Long id;
	private LocalDate fecha;
	private LocalTime hora;

	public ModificarTurnoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModificarTurnoDTO(Long id, LocalDate fecha, LocalTime hora) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
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

}
