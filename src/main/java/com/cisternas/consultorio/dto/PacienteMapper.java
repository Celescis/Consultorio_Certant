package com.cisternas.consultorio.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cisternas.consultorio.model.Paciente;

@Component
public class PacienteMapper {

	public Paciente dtoToEntity(PacienteDTO dto) {
		Paciente entity = new Paciente();
		entity.setCuil(dto.getCuil());
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());
		entity.setObraSocial(dto.getObraSocial());
		entity.setTelefono(dto.getTelefono());

		return entity;
	}

	public PacienteDTO entityToDto(Paciente entity) {
		PacienteDTO dto = new PacienteDTO();
		dto.setCuil(entity.getCuil());
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());
		dto.setObraSocial(entity.getObraSocial());
		dto.setTelefono(entity.getTelefono());

		return dto;
	}

	public List<PacienteDTO> lstEntityToLstDto(List<Paciente> entityList) {
		List<PacienteDTO> dtoList = new ArrayList<>();

		for (Paciente ent : entityList) {
			dtoList.add(this.entityToDto(ent));
		}

		return dtoList;
	}

	public List<Paciente> lstDtoToLstEntity(List<PacienteDTO> dtoList) {
		List<Paciente> lst = new ArrayList<>();

		for (PacienteDTO dto : dtoList) {
			lst.add(this.dtoToEntity(dto));
		}

		return lst;
	}
}
