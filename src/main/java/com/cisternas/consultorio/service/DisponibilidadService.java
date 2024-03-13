package com.cisternas.consultorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisternas.consultorio.dto.DisponibilidadDTO;
import com.cisternas.consultorio.dto.DisponibilidadMapper;
import com.cisternas.consultorio.model.Disponibilidad;
import com.cisternas.consultorio.model.Profesional;
import com.cisternas.consultorio.repository.DisponibilidadRepository;

@Service
public class DisponibilidadService {

	@Autowired
	private DisponibilidadRepository disponibilidadRepository;

	@Autowired
	private DisponibilidadMapper disponibilidadMapper;

	public void asignarDisponibilidad(Profesional profesional, List<Disponibilidad> disponibilidad) {

		for (Disponibilidad disp : disponibilidad) {
			disp.setProfesional(profesional);

			disponibilidadRepository.save(disp);
		}
	}

	public List<Disponibilidad> mappeoLstDto(List<DisponibilidadDTO> disponibilidadDTO) {
		return disponibilidadMapper.lstDtoToLstEntity(disponibilidadDTO);
	}

}
