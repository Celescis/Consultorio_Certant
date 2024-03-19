package com.cisternas.consultorio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisternas.consultorio.dto.DisponibilidadDTO;
import com.cisternas.consultorio.dto.DisponibilidadMapper;
import com.cisternas.consultorio.model.Disponibilidad;
import com.cisternas.consultorio.model.Profesional;
import com.cisternas.consultorio.repository.DisponibilidadRepository;
import java.time.DayOfWeek;
import java.util.Locale;

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

	public DayOfWeek convertirADayOfWeek(String dia) {
		switch (dia.toUpperCase(Locale.ROOT)) {

		case "LUNES":
			return DayOfWeek.MONDAY;
		case "MARTES":
			return DayOfWeek.TUESDAY;
		case "MIERCOLES":
			return DayOfWeek.WEDNESDAY;
		case "JUEVES":
			return DayOfWeek.THURSDAY;
		case "VIERNES":
			return DayOfWeek.FRIDAY;
		case "SÁBADO":
			return DayOfWeek.SATURDAY;
		default:
			throw new IllegalArgumentException("Día inválido: " + dia);
		}
	}

}
