package com.cisternas.consultorio.controller;

import java.util.List;
import java.lang.Long;

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

import com.cisternas.consultorio.dto.PacienteDTO;
import com.cisternas.consultorio.dto.PacienteMapper;
import com.cisternas.consultorio.model.Paciente;
import com.cisternas.consultorio.repository.PacienteRepository;

@RestController
@RequestMapping("/pac")
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private PacienteMapper pacienteMapper;

	// private ProfesionalService pacienteService;

	// GET - UN PACIENTE
	@GetMapping("/get/{cuil}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long cuil) {
	    try {
	        Paciente paciente = pacienteRepository.findByCuil(cuil);
	        if (paciente != null) {
	            return new ResponseEntity<>(paciente, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Paciente no encontrado con cuil: " + cuil, HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        return new ResponseEntity<>("Error obteniendo al paciente: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	// GET - LISTA DE PACIENTES
	@GetMapping
	public ResponseEntity<?> obtenerLista() {
		try {

			List<Paciente> pacientes = (List<Paciente>) pacienteRepository.findAll();
			if (pacientes.isEmpty()) {
				return new ResponseEntity<String>("No se encontraron pacientes. ", HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<PacienteDTO>>(pacienteMapper.lstEntityToLstDto(pacientes),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error obteniendo la lista de pacientes: " + e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}

	// POST - CREAR UN PACIENTE
	@PostMapping("/post")
	public ResponseEntity<?> crear(@RequestBody @Validated Paciente paciente) {
		try {
			if (paciente.getCuil() == null) {
				return new ResponseEntity<>("El cuil es obligatorio.", HttpStatus.BAD_REQUEST);
			}

			String cuilStr = paciente.getCuil().toString();

			if (cuilStr.trim().isEmpty() || cuilStr.equals("0") || cuilStr.length() != 11 || !cuilStr.matches("\\d+")) {
				return new ResponseEntity<>(
						"El cuil debe ser de 11 dígitos, no puede estar vacío o contener caracteres no numéricos.",
						HttpStatus.BAD_REQUEST);
			}

			Paciente pac = pacienteRepository.findByCuil(paciente.getCuil());
			if (pac == null) {
				pacienteRepository.save(paciente);
				return new ResponseEntity<>("Se creó el paciente con cuil: " + paciente.getCuil(), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>("Ya existe un paciente con ese cuil: " + pac.getCuil(),
						HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error al crear el paciente: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// PUT - MODIFICAR UN PACIENTE
	@PutMapping("/put/{cuil}")
	public ResponseEntity<?> modificar(@PathVariable Long cuil, @RequestBody @Validated PacienteDTO pacienteDTO) {

		try {
			Paciente paciente = pacienteRepository.findByCuil(cuil);
			if (paciente.getCuil() != null) {
				Paciente pacNuevo = pacienteMapper.dtoToEntity(pacienteDTO);

				pacienteRepository.save(pacNuevo);

				return new ResponseEntity<String>("Se modifico satisfactoriamente el paciente con cuil: " + cuil,
						HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existe un paciente con ese cuil: " + cuil, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error al modificar el paciente :" + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// DELETE - BORRAR UN PACIENTE
	@DeleteMapping("/delete/{cuil}")
	public ResponseEntity<?> eliminar(@PathVariable Long cuil) {
		try {
			Paciente paciente = pacienteRepository.findByCuil(cuil);
			if (paciente != null) {

				pacienteRepository.delete(paciente);

				return new ResponseEntity<String>("Se elimino el paciente de cuil: " + paciente.getCuil(),
						HttpStatus.OK);

			} else {

				return new ResponseEntity<String>("Paciente no encontrado con cuil: " + cuil, HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error eliminando al paciente: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
