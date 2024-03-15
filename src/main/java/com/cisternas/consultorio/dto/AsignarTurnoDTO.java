package com.cisternas.consultorio.dto;

public class AsignarTurnoDTO {
	private Long idTurno;
	private Long cuil;
	public AsignarTurnoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AsignarTurnoDTO(Long idTurno, Long cuil) {
		super();
		this.idTurno = idTurno;
		this.cuil = cuil;
	}
	public Long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}
	public Long getCuil() {
		return cuil;
	}
	public void setCuil(Long cuil) {
		this.cuil = cuil;
	}
	
}
