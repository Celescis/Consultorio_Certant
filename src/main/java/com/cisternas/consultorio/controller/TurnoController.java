package com.cisternas.consultorio.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.cisternas.consultorio.dto.AsignarTurnoDTO;
import com.cisternas.consultorio.dto.ModificarTurnoDTO;
import com.cisternas.consultorio.dto.PacienteDTO;
import com.cisternas.consultorio.dto.PacienteMapper;
import com.cisternas.consultorio.dto.TurnoDTO;
import com.cisternas.consultorio.dto.TurnoMapper;
import com.cisternas.consultorio.model.Paciente;
import com.cisternas.consultorio.model.Turno;
import com.cisternas.consultorio.repository.PacienteRepository;
import com.cisternas.consultorio.repository.TurnoRepository;
import com.cisternas.consultorio.service.TurnoService;

@RestController
@RequestMapping("/tur")
public class TurnoController {

	@Autowired
	private PacienteRepository pacienteRepository;

	private PacienteMapper pacienteMapper;

	@Autowired
	private TurnoMapper turnoMapper;

	@Autowired
	private TurnoService turnoService;

	@Autowired
	private TurnoRepository turnoRepository;

	// GET - UN TURNO
	@GetMapping("/get/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
		try {
			Optional<Turno> turno = turnoRepository.findById(id);
			if (turno.isPresent()) {
				return new ResponseEntity<>(turno.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Turno no encontrado con id: " + id, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error obteniendo al turno: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// GET - LISTA DE TURNOS
	@GetMapping
	public ResponseEntity<?> obtenerLista() {
		try {

			List<Turno> turnos = (List<Turno>) turnoRepository.findAll();
			if (turnos.isEmpty()) {
				return new ResponseEntity<String>("No se encontraron turnos. ", HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<TurnoDTO>>(turnoMapper.lstEntityToLstDto(turnos), HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>("Error obteniendo la lista de turnos: " + e.getMessage(),
					HttpStatus.BAD_REQUEST);
		}
	}

	// PUT - ASIGNAR UN TURNO
	@PutMapping("/put/asignar")
	public ResponseEntity<?> asignar(@RequestBody AsignarTurnoDTO asignarTurnoDTO) {
		try {
			Map<String, Object> serviceResponse = turnoService.asignarTurno(asignarTurnoDTO);

			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// PUT - CANCELAR UN TURNO
	@PutMapping("/put/cancelar")
	public ResponseEntity<?> cancelar(@RequestBody AsignarTurnoDTO asignarTurnoDTO) {
		try {
			Map<String, Object> serviceResponse = turnoService.cancelarTurno(asignarTurnoDTO);

			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// PUT - MODIFICAR UN TURNO
	@PutMapping("/put/modificar")
	public ResponseEntity<?> modificar(@RequestBody ModificarTurnoDTO modificarTurnoDTO) {
		try {
			Map<String, Object> serviceResponse = turnoService.modificarTurno(modificarTurnoDTO);

			return new ResponseEntity<>(serviceResponse, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
