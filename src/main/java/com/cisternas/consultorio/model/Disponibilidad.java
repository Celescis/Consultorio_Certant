package com.cisternas.consultorio.model;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "sys_disponibilidad")
public class Disponibilidad implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dis_id")
	private Long id;

	@NotBlank(message = "Debe ingresar el dia disponible")
	@Column(name = "dis_dia")
	private String dia;

	@NotNull(message = "Debe ingresar comienzo jornada")
	@Column(name = "dis_horaInicio")
	private LocalTime horaInicio;

	@NotNull(message = "Debe ingresar fin jornada")
	@Column(name = "dis_horaFin")
	private LocalTime horaFin;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_matricula", referencedColumnName = "pro_matricula")
    private Profesional profesional;

	public Disponibilidad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disponibilidad(Long id, @NotBlank(message = "Debe ingresar el dia disponible") String dia,
			@NotNull(message = "Debe ingresar comienzo jornada") LocalTime horaInicio,
			@NotNull(message = "Debe ingresar fin jornada") LocalTime horaFin, Profesional profesional) {
		super();
		this.id = id;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.profesional = profesional;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	@Override
	public String toString() {
		return "Disponibilidad [id=" + id + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin
				+ ", profesional=" + profesional + "]";
	}

}
