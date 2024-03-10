package com.cisternas.consultorio.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cisternas.consultorio.model.Turno;

@Component
public class TurnoMapper {

	private AgendaMapper agendaMapper;

	private ConsultorioMapper consultorioMapper;

	private PacienteMapper pacienteMapper;

	public Turno dtoToEntity(TurnoDTO dto) {
		Turno entity = new Turno();
		entity.setId(dto.getId());
		entity.setFecha(dto.getFecha());
		entity.setHora(dto.getHora());

		if (dto.getAgenda() != null) {
			entity.setAgenda(agendaMapper.dtoToEntity(dto.getAgenda()));
		}

		entity.setReservado(dto.isReservado());
		entity.setEstado(dto.getEstado());

		if (dto.getConsultorio() != null) {
			entity.setConsultorio(consultorioMapper.dtoToEntity(dto.getConsultorio()));
		}

		if (dto.getPaciente() != null) {
			entity.setPaciente(pacienteMapper.dtoToEntity(dto.getPaciente()));
		}

		return entity;
	}

	public TurnoDTO entityToDto(Turno entity) {
		TurnoDTO dto = new TurnoDTO();
		dto.setId(entity.getId());
		dto.setFecha(entity.getFecha());
		dto.setHora(entity.getHora());

		if (entity.getAgenda() != null) {
			dto.setAgenda(agendaMapper.entityToDto(entity.getAgenda()));
		}

		dto.setReservado(entity.isReservado());
		dto.setEstado(entity.getEstado());

		if (entity.getConsultorio() != null) {
			dto.setConsultorio(consultorioMapper.entityToDto(entity.getConsultorio()));
		}

		if (entity.getPaciente() != null) {
			dto.setPaciente(pacienteMapper.entityToDto(entity.getPaciente()));
		}

		return dto;
	}

	public List<TurnoDTO> lstEntityToLstDto(List<Turno> entityList) {
		List<TurnoDTO> dtoList = new ArrayList<>();

		for (Turno ent : entityList) {
			dtoList.add(this.entityToDto(ent));
		}

		return dtoList;
	}

	public List<Turno> lstDtoToLstEntity(List<TurnoDTO> dtoList) {
		List<Turno> lst = new ArrayList<>();

		for (TurnoDTO dto : dtoList) {
			lst.add(this.dtoToEntity(dto));
		}

		return lst;
	}
}
