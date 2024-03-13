package com.cisternas.consultorio.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.cisternas.consultorio.model.Profesional;
import com.cisternas.consultorio.service.DisponibilidadService;

@Component
public class ProfesionalMapper {

	@Autowired
	private EspecialidadMapper especialidadMapper;

	public Profesional dtoToEntity(ProfesionalDTO dto) {
		Profesional entity = new Profesional();

		entity.setMatricula(dto.getMatricula());
		entity.setNombre(dto.getNombre());
		entity.setApellido(dto.getApellido());

		if (dto.getEspecialidad() != null) {
			entity.setEspecialidad(especialidadMapper.dtoToEntity(dto.getEspecialidad()));
		}

		return entity;
	}

	public ProfesionalDTO entityToDto(Profesional entity) {
		ProfesionalDTO dto = new ProfesionalDTO();

		dto.setMatricula(entity.getMatricula());
		dto.setNombre(entity.getNombre());
		dto.setApellido(entity.getApellido());

		if (entity.getEspecialidad() != null) {
			dto.setEspecialidad(especialidadMapper.entityToDto(entity.getEspecialidad()));
		}

		return dto;
	}

	public List<ProfesionalDTO> lstEntityToLstDto(List<Profesional> entityList) {
		List<ProfesionalDTO> dtoList = new ArrayList<>();

		for (Profesional ent : entityList) {
			dtoList.add(this.entityToDto(ent));
		}

		return dtoList;
	}

	public List<Profesional> lstDtoToLstEntity(List<ProfesionalDTO> dtoList) {
		List<Profesional> lst = new ArrayList<>();

		for (ProfesionalDTO dto : dtoList) {
			lst.add(this.dtoToEntity(dto));
		}

		return lst;
	}
}
