package com.cisternas.consultorio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cisternas.consultorio.dto.DisponibilidadDTO;
import com.cisternas.consultorio.dto.ProfesionalDTO;
import com.cisternas.consultorio.dto.ProfesionalMapper;
import com.cisternas.consultorio.model.Agenda;
import com.cisternas.consultorio.model.Disponibilidad;
import com.cisternas.consultorio.model.Profesional;
import com.cisternas.consultorio.repository.ProfesionalRepository;

@Service
@Transactional
public class ProfesionalService {
	@Autowired
	private ProfesionalMapper profesionalMapper;

	@Autowired
	private ProfesionalRepository profesionalRepository;

	@Autowired
	private DisponibilidadService disponibilidadService;

	@Autowired
	private AgendaService agendaService;

	@Autowired
	private TurnoService turnoService;

	public Map<String, Object> crear(ProfesionalDTO profesionalDTO) {
		Map<String, Object> response = new HashMap<>();
		Profesional profesional = profesionalMapper.dtoToEntity(profesionalDTO);

		Profesional profesionalGuardado = profesionalRepository.save(profesional);

		if (!profesionalDTO.getDisponibilidad().isEmpty()) {
			// GUARDO LA LISTA DE DISPONIBILIDAD
			List<Disponibilidad> disponibilidadList = disponibilidadService
					.mappeoLstDto(profesionalDTO.getDisponibilidad());

			// ASIGNO LA DISPONIBILIDAD AL PROFESIONAL Y LO GUARDO EN LA BASE DE DATOS
			disponibilidadService.asignarDisponibilidad(profesionalGuardado, disponibilidadList);

			// GENERO LA AGENDA DEL PROFESIONAL
			Agenda agenda = agendaService.generarAgenda(profesionalGuardado);

			// GENERO LOS TURNOS A PARTIR DE LA DISPONIBILIDAD Y LO GUARDO EN LA AGENDA
			agenda.setTurnos(turnoService.generarTurnos(agenda, disponibilidadList));
			profesionalGuardado.setAgenda(agenda);
			profesionalRepository.save(profesionalGuardado);

			response.put("msg",
					"Se creó el profesional con matrícula y disponibilidad: " + profesionalGuardado.getMatricula());
		} else {
			response.put("msg", "Se creó el profesional con matrícula: " + profesionalGuardado.getMatricula()
					+ " sin disponibilidad.");
		}

		response.put("profesional", profesionalMapper.entityToDto(profesionalGuardado));

		return response;
	}
}
