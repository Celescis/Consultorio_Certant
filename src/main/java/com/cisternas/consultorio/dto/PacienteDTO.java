package com.cisternas.consultorio.dto;

public class PacienteDTO {

	private Long cuil;
	private String nombre;
	private String apellido;
	private String obraSocial;
	private String telefono;

	public PacienteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PacienteDTO(Long cuil, String nombre, String apellido, String obraSocial, String telefono) {
		super();
		this.cuil = cuil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.obraSocial = obraSocial;
		this.telefono = telefono;
	}

	public Long getCuil() {
		return cuil;
	}

	public void setCuil(Long cuil) {
		this.cuil = cuil;
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

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
