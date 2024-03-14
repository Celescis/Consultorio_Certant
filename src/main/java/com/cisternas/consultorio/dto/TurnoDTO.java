package com.cisternas.consultorio.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cisternas.consultorio.model.Turno.EnEstado;

public class TurnoDTO {

	private Long id;
	private LocalDate fecha;
	private LocalTime hora;
	private AgendaDTO agenda;
	private EnEstado estado;
	private ConsultorioDTO consultorio;
	private PacienteDTO paciente;

	public TurnoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TurnoDTO(Long id, LocalDate fecha, LocalTime hora, AgendaDTO agenda, EnEstado estado,
			ConsultorioDTO consultorio, PacienteDTO paciente) {
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

	public AgendaDTO getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaDTO agenda) {
		this.agenda = agenda;
	}

	public EnEstado getEstado() {
		return estado;
	}

	public void setEstado(EnEstado estado) {
		this.estado = estado;
	}

	public ConsultorioDTO getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(ConsultorioDTO consultorio) {
		this.consultorio = consultorio;
	}

	public PacienteDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "TurnoDTO [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", agenda=" + agenda + ", estado="
				+ estado + ", consultorio=" + consultorio + ", paciente=" + paciente + "]";
	}

}
