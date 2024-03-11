package com.cisternas.consultorio.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisternas.consultorio.model.Agenda;

@Component
public class AgendaMapper {

	private ProfesionalMapper profesionalMapper;
	private TurnoMapper turnoMapper;

	@Autowired
	public void setTurnoMapper(TurnoMapper turnoMapper) {
		this.turnoMapper = turnoMapper;
	}

	@Autowired
	public void setProfesionalMapper(ProfesionalMapper profesionalMapper) {
		this.profesionalMapper = profesionalMapper;
	}

	public Agenda dtoToEntity(AgendaDTO dto) {
		Agenda entity = new Agenda();

		entity.setId(dto.getId());
		if (dto.getProfesional() != null) {
			entity.setProfesional(profesionalMapper.dtoToEntity(dto.getProfesional()));
		}
		if (dto.getTurnos() != null) {
			entity.setTurnos(turnoMapper.lstDtoToLstEntity(dto.getTurnos()));
		}

		return entity;
	}

	public AgendaDTO entityToDto(Agenda entity) {
		AgendaDTO dto = new AgendaDTO();

		dto.setId(entity.getId());
		if (entity.getProfesional() != null) {
			dto.setProfesional(profesionalMapper.entityToDto(entity.getProfesional()));
		}
		if (entity.getTurnos() != null) {
			dto.setTurnos(turnoMapper.lstEntityToLstDto(entity.getTurnos()));
		}

		return dto;
	}

	public List<AgendaDTO> lstEntityToLstDto(List<Agenda> entityList) {
		List<AgendaDTO> dtoList = new ArrayList<>();

		for (Agenda ent : entityList) {
			dtoList.add(this.entityToDto(ent));
		}

		return dtoList;
	}

	public List<Agenda> lstDtoToLstEntity(List<AgendaDTO> dtoList) {
		List<Agenda> lst = new ArrayList<>();

		for (AgendaDTO dto : dtoList) {
			lst.add(this.dtoToEntity(dto));
		}

		return lst;
	}
}
