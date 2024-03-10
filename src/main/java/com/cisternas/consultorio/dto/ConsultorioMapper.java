package com.cisternas.consultorio.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cisternas.consultorio.model.Consultorio;

@Component
public class ConsultorioMapper {

	public ConsultorioDTO entityToDto(Consultorio entity) {
		return new ConsultorioDTO(entity.getId());
	}

	public Consultorio dtoToEntity(ConsultorioDTO dto) {
		Consultorio entity = new Consultorio();
		entity.setId(dto.getId());
		return entity;
	}

	public List<ConsultorioDTO> lstEntityToLstDto(List<Consultorio> entityList) {
		List<ConsultorioDTO> dtoList = new ArrayList<>();

		for (Consultorio ent : entityList) {
			dtoList.add(this.entityToDto(ent));
		}

		return dtoList;
	}

	public List<Consultorio> lstDtoToLstEntity(List<ConsultorioDTO> dtoList) {
		List<Consultorio> lst = new ArrayList<>();

		for (ConsultorioDTO dto : dtoList) {
			lst.add(this.dtoToEntity(dto));
		}

		return lst;
	}
}
