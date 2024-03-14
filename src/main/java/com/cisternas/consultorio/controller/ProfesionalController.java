package com.cisternas.consultorio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisternas.consultorio.dto.ProfesionalDTO;
import com.cisternas.consultorio.dto.ProfesionalMapper;
import com.cisternas.consultorio.model.Disponibilidad;
import com.cisternas.consultorio.model.Profesional;
import com.cisternas.consultorio.repository.ProfesionalRepository;
import com.cisternas.consultorio.service.DisponibilidadService;
import com.cisternas.consultorio.service.ProfesionalService;

@RestController
@RequestMapping("/pro")
public class ProfesionalController {

	@Autowired
	private ProfesionalRepository profesionalRepository;

	@Autowired
	private ProfesionalMapper profesionalMapper;

	@Autowired
	private ProfesionalService profesionalService;

	// GET - UN PROFESIONAL
	@GetMapping("/get/{matricula}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long matricula) {
		try {
			Profesional paciente = profesionalRepository.findByMatricula(matricula);
			if (paciente != null) {
				return new ResponseEntity<>(paciente, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Profesional no encontrado con matricula: " + matricula,
						HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error obteniendo al profesional: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// GET - LISTA DE PROFESIONALES
	@GetMapping
	public ResponseEntity<?> obtenerLista() {
		try {

			List<Profesional> profesionales = (List<Profesional>) profesionalRepository.findAll();
			if (profesionales.isEmpty()) {
				return new ResponseEntity<String>("No se encontraron profesionales. ", HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<ProfesionalDTO>>(profesionalMapper.lstEntityToLstDto(profesionales),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error obteniendo la lista de profesionales: " + e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}

	// POST - CREAR UN PROFESIONAL
	@PostMapping("/post")
	public ResponseEntity<?> crear(@RequestBody @Validated ProfesionalDTO profesionalDTO) {
		try {
			if (profesionalDTO.getMatricula() == null) {
				return new ResponseEntity<>("La matricula es obligatoria.", HttpStatus.BAD_REQUEST);
			}

			Profesional prof = profesionalRepository.findByMatricula(profesionalDTO.getMatricula());
			if (prof == null) {
				Map<String, Object> serviceResponse = profesionalService.crear(profesionalDTO);
				return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);

			} else {
				return new ResponseEntity<>(
						"Ya existe un profesional con ese matricula: " + profesionalDTO.getMatricula(),
						HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error al crear el profesional: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// PUT - MODIFICAR UN PROFESIONAL
	@PutMapping("/put/{matricula}")
	public ResponseEntity<?> modificar(@PathVariable Long matricula,
			@RequestBody @Validated ProfesionalDTO profesionalDTO) {

		try {
			Profesional profesional = profesionalRepository.findByMatricula(matricula);
			if (profesional.getMatricula() != null) {
				Profesional profesionalNuevo = profesionalMapper.dtoToEntity(profesionalDTO);

				profesionalRepository.save(profesionalNuevo);

				return new ResponseEntity<String>(
						"Se modifico satisfactoriamente el profesional con matricula: " + matricula, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existe un profesional con ese matricula: " + matricula,
						HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error al modificar el profesional :" + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// DELETE - BORRAR UN PROFESIONAL
	@DeleteMapping("/delete/{matricula}")
	public ResponseEntity<?> eliminar(@PathVariable Long matricula) {
		try {
			Profesional profesional = profesionalRepository.findByMatricula(matricula);
			if (profesional != null) {

				profesionalRepository.delete(profesional);

				return new ResponseEntity<String>(
						"Se elimino el profesional de matricula: " + profesional.getMatricula(), HttpStatus.OK);

			} else {

				return new ResponseEntity<String>("Profesional no encontrado con matricula: " + matricula,
						HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error eliminando al profesional: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
