package com.cisternas.consultorio.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisternas.consultorio.model.Disponibilidad;

@Component
public class DisponibilidadMapper {

	private ProfesionalMapper profesionalMapper;

	public Disponibilidad dtoToEntity(DisponibilidadDTO dto) {
		Disponibilidad entity = new Disponibilidad();

		entity.setId(dto.getId());
		entity.setDia(dto.getDia());
		entity.setHoraInicio(dto.getHoraInicio());
		entity.setHoraFin(dto.getHoraFin());
		if (dto.getProfesional() != null) {
			entity.setProfesional(profesionalMapper.dtoToEntity(dto.getProfesional()));
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
			dto.setProfesional(profesionalMapper.entityToDto(entity.getProfesional()));
		}

		return dto;
	}

	public Set<DisponibilidadDTO> lstEntityToLstDto(Set<Disponibilidad> entityList) {
		Set<DisponibilidadDTO> dtoList = new HashSet<>();

		for (Disponibilidad ent : entityList) {
			dtoList.add(this.entityToDto(ent));
		}

		return dtoList;
	}

	public Set<Disponibilidad> lstDtoToLstEntity(Set<DisponibilidadDTO> dtoList) {
		Set<Disponibilidad> lst = new HashSet<>();

		for (DisponibilidadDTO dto : dtoList) {
			lst.add(this.dtoToEntity(dto));
		}

		return lst;
	}
}
