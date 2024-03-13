package com.cisternas.consultorio.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cisternas.consultorio.dto.DisponibilidadDTO;
import com.cisternas.consultorio.dto.ProfesionalDTO;
import com.cisternas.consultorio.dto.ProfesionalMapper;
import com.cisternas.consultorio.model.Disponibilidad;
import com.cisternas.consultorio.model.Profesional;
import com.cisternas.consultorio.repository.ProfesionalRepository;

@Service
public class ProfesionalService {
	@Autowired
	private ProfesionalMapper profesionalMapper;

	@Autowired
	private ProfesionalRepository profesionalRepository;

	@Autowired
	private DisponibilidadService disponibilidadService;

	// @Autowired
	// private AgendaService agendaService;

	public ResponseEntity<Map<String, Object>> crear(ProfesionalDTO profesionalDTO) {
		Map<String, Object> response = new HashMap<>();
		Profesional profesional = profesionalMapper.dtoToEntity(profesionalDTO);

		Profesional profesionalGuardado = profesionalRepository.save(profesional);

		if (!profesionalDTO.getDisponibilidad().isEmpty()) {
			List<Disponibilidad> disponibilidadList = disponibilidadService
					.mappeoLstDto(profesionalDTO.getDisponibilidad());
			disponibilidadService.asignarDisponibilidad(profesionalGuardado, disponibilidadList);
			response.put("msg",
					"Se creó el profesional con matrícula y disponibilidad: " + profesionalGuardado.getMatricula());
		} else {
			response.put("msg", "Se creó el profesional con matrícula: " + profesionalGuardado.getMatricula()
					+ " sin disponibilidad.");
		}

		// return ResponseEntity.ok(response);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
