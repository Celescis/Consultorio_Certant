package com.cisternas.consultorio.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cisternas.consultorio.model.Especialidad;

@Component
public class EspecialidadMapper {

	public Especialidad dtoToEntity(EspecialidadDTO dto) {
		Especialidad entity = new Especialidad();

		if (dto.getId() != null) {
			entity.setId(dto.getId());
			entity.setDescripcion(dto.getDescripcion());
		}

		return entity;
	}

	public EspecialidadDTO entityToDto(Especialidad entity) {
		EspecialidadDTO dto = new EspecialidadDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
			dto.setDescripcion(entity.getDescripcion());
		}

		return dto;
	}

	public List<EspecialidadDTO> lstEntityToLstDto(List<Especialidad> entityList) {
		List<EspecialidadDTO> dtoList = new ArrayList<>();

		for (Especialidad ent : entityList) {
			dtoList.add(this.entityToDto(ent));
		}

		return dtoList;
	}

	public List<Especialidad> lstDtoToLstEntity(List<EspecialidadDTO> dtoList) {
		List<Especialidad> lst = new ArrayList<>();

		for (EspecialidadDTO dto : dtoList) {
			lst.add(this.dtoToEntity(dto));
		}

		return lst;
	}
}
