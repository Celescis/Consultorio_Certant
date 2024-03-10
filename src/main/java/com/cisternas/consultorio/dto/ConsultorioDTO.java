package com.cisternas.consultorio.dto;

public class ConsultorioDTO {
	private Long id;

	public ConsultorioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConsultorioDTO(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ConsultorioDTO [id=" + id + "]";
	}

}
