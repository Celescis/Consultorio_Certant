package com.cisternas.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisternas.consultorio.dto.EspecialidadDTO;
import com.cisternas.consultorio.dto.EspecialidadMapper;
import com.cisternas.consultorio.model.Especialidad;
import com.cisternas.consultorio.repository.EspecialidadRepository;

@RestController
@RequestMapping("/esp")
public class EspecialidadController {

	@Autowired
	EspecialidadRepository especialidadRepository;

	@Autowired
	EspecialidadMapper especialidadMapper;

	// GET - UNA ESPECIALIDAD
	@GetMapping("/get/{descripcion}")
	public ResponseEntity<?> obtenerUno(@PathVariable String descripcion) {
		try {
			Especialidad especialidad = especialidadRepository.findByDescripcion(descripcion);
			if (especialidad != null) {
				return new ResponseEntity<>(especialidad, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Especialidad no encontrada. ", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error obteniendo la especialidad: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// GET - LISTA DE ESPECIALIDADES
	@GetMapping
	public ResponseEntity<?> obtenerLista() {
		try {

			List<Especialidad> especialidades = (List<Especialidad>) especialidadRepository.findAll();
			if (especialidades.isEmpty()) {
				return new ResponseEntity<String>("No se encontraron especialidades. ", HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<EspecialidadDTO>>(especialidadMapper.lstEntityToLstDto(especialidades),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error obteniendo la lista de especialidades: " + e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}

	// POST - CREAR UNA ESPECIALIDAD
	@PostMapping("/post")
	public ResponseEntity<?> crear(@RequestBody @Validated Especialidad especialidad) {
		try {

			Especialidad esp = especialidadRepository.findByDescripcion(especialidad.getDescripcion());
			if (esp == null) {
				especialidadRepository.save(especialidad);
				return new ResponseEntity<>("Se creó la especialidad: " + especialidad.getDescripcion(),
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Ya existe una especialidad con ese nombre: " + esp.getDescripcion(),
						HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error al crear la especialidad: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// DELETE - BORRAR UNA ESPECIALIDAD
	@DeleteMapping("/delete/{descripcion}")
	public ResponseEntity<?> eliminar(@PathVariable String descripcion) {
		try {
			Especialidad especialidad = especialidadRepository.findByDescripcion(descripcion);
			if (especialidad != null) {

				especialidadRepository.delete(especialidad);

				return new ResponseEntity<String>("Se elimino la especialidad: " + descripcion, HttpStatus.OK);

			} else {

				return new ResponseEntity<String>("Especialidad no encontrada: ", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error eliminando la especialidad: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
