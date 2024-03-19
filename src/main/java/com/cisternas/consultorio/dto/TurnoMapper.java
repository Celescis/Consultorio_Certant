package com.cisternas.consultorio.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.cisternas.consultorio.model.Turno;

@Component
public class TurnoMapper {

	private final ConsultorioMapper consultorioMapper;
	private final PacienteMapper pacienteMapper;
	private final EspecialidadMapper especialidadMapper;

	@Autowired
	public TurnoMapper(@Lazy ConsultorioMapper consultorioMapper, PacienteMapper pacienteMapper,
			EspecialidadMapper especialidadMapper) {
		this.consultorioMapper = consultorioMapper;
		this.pacienteMapper = pacienteMapper;
		this.especialidadMapper = especialidadMapper;
	}

	public Turno dtoToEntity(TurnoDTO dto) {
		Turno entity = new Turno();
		entity.setId(dto.getId());
		entity.setFecha(dto.getFecha());
		entity.setHora(dto.getHora());

		entity.setEstado(dto.getEstado());

		if (dto.getConsultorio() != null) {
			entity.setConsultorio(consultorioMapper.dtoToEntity(dto.getConsultorio()));
		}

		if (dto.getPaciente() != null) {
			entity.setPaciente(pacienteMapper.dtoToEntity(dto.getPaciente()));
		}

		if (dto.getEspecialidad() != null) {
			entity.setEspecialidad(especialidadMapper.dtoToEntity(dto.getEspecialidad()));
		}

		return entity;
	}

	public TurnoDTO entityToDto(Turno entity) {
		TurnoDTO dto = new TurnoDTO();
		dto.setId(entity.getId());
		dto.setFecha(entity.getFecha());
		dto.setHora(entity.getHora());

		dto.setEstado(entity.getEstado());

		if (entity.getConsultorio() != null) {
			dto.setConsultorio(consultorioMapper.entityToDto(entity.getConsultorio()));
		}

		if (entity.getPaciente() != null) {
			dto.setPaciente(pacienteMapper.entityToDto(entity.getPaciente()));
		}

		if (entity.getEspecialidad() != null) {
			dto.setEspecialidad(especialidadMapper.entityToDto(entity.getEspecialidad()));
		}

		if (entity.getProfesional() != null) {
			dto.setProfesionalId(entity.getProfesional().getMatricula());
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
