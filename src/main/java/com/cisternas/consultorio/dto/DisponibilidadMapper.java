package com.cisternas.consultorio.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisternas.consultorio.model.Disponibilidad;

@Component
public class DisponibilidadMapper {

	ProfesionalMapper profesionalMapper;

	@Autowired
	public void setProfesionalMapper(ProfesionalMapper profesionalMapper) {
		this.profesionalMapper = profesionalMapper;
	}

	public Disponibilidad dtoToEntity(DisponibilidadDTO dto) {
		Disponibilidad entity = new Disponibilidad();

		entity.setId(dto.getId());
		entity.setDia(dto.getDia());
		entity.setHoraInicio(dto.getHoraInicio());
		entity.setHoraFin(dto.getHoraFin());
		if (dto.getProfesionalDTO() != null) {
			entity.setProfesional(profesionalMapper.dtoToEntity(dto.getProfesionalDTO()));
		}

		return entity;
	}

	public DisponibilidadDTO entityToDto(Disponibilidad entity) {
		DisponibilidadDTO dto = new DisponibilidadDTO();

		dto.setId(entity.getId());
		dto.setDia(entity.getDia());
		dto.setHoraInicio(entity.getHoraInicio());
		dto.setHoraFin(entity.getHoraFin());
		if (entity.getProfesional() != null) {
			dto.setProfesionalDTO(profesionalMapper.entityToDto(entity.getProfesional()));
		}
		return dto;
	}

	public List<DisponibilidadDTO> lstEntityToLstDto(List<Disponibilidad> entityList) {
		List<DisponibilidadDTO> dtoList = new ArrayList<>();

		for (Disponibilidad ent : entityList) {
			dtoList.add(this.entityToDto(ent));
		}

		return dtoList;
	}

	public List<Disponibilidad> lstDtoToLstEntity(List<DisponibilidadDTO> dtoList) {
		List<Disponibilidad> lst = new ArrayList<>();

		for (DisponibilidadDTO dto : dtoList) {
			lst.add(this.dtoToEntity(dto));
		}

		return lst;
	}
}
