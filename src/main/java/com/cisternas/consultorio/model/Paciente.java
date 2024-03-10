package com.cisternas.consultorio.model;
import java.lang.Long;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "sys_paciente")
public class Paciente implements Serializable {

	@Id
	@NotNull(message = "Debe ingresar el cuil")
	@Column(name = "pac_cuil", unique = true)
	private Long cuil;

	@NotBlank(message = "Debe ingresar el nombre")
	@Column(name = "pac_nombre")
	private String nombre;

	@NotBlank(message = "Debe ingresar el apellido")
	@Column(name = "pac_apellido")
	private String apellido;

	@NotBlank(message = "Debe ingresar la obra social")
	@Column(name = "pac_obraSocial")
	private String obraSocial;

	@Size(min = 10, message = "El número de teléfono debe tener al menos 10 dígitos")
	@Column(name = "pac_telefono")
	private String telefono;

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(@NotNull(message = "Debe ingresar el cuil") Long cuil,
			@NotBlank(message = "Debe ingresar el nombre") String nombre,
			@NotBlank(message = "Debe ingresar el apellido") String apellido,
			@NotBlank(message = "Debe ingresar la obra social") String obraSocial,
			@Size(min = 10, message = "El número de teléfono debe tener al menos 10 dígitos") String telefono) {
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

	@Override
	public String toString() {
		return "Paciente [cuil=" + cuil + ", nombre=" + nombre + ", apellido=" + apellido + ", obraSocial=" + obraSocial
				+ ", telefono=" + telefono + "]";
	}

}
