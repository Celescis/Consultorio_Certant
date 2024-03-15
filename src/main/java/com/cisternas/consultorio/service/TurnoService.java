package com.cisternas.consultorio.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cisternas.consultorio.dto.AsignarTurnoDTO;
import com.cisternas.consultorio.dto.ModificarTurnoDTO;
import com.cisternas.consultorio.dto.TurnoDTO;
import com.cisternas.consultorio.dto.TurnoMapper;
import com.cisternas.consultorio.model.Agenda;
import com.cisternas.consultorio.model.Disponibilidad;
import com.cisternas.consultorio.model.Paciente;
import com.cisternas.consultorio.model.Turno;
import com.cisternas.consultorio.repository.AgendaRepository;
import com.cisternas.consultorio.repository.PacienteRepository;
import com.cisternas.consultorio.repository.TurnoRepository;

@Service
public class TurnoService {
	@Autowired
	private TurnoRepository turnoRepository;

	@Autowired
	private DisponibilidadService disponibilidadService;

	@Autowired
	private AgendaRepository agendaRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private TurnoMapper turnoMapper;

	@Transactional
	public List<Turno> generarTurnos(Agenda agenda, List<Disponibilidad> disponibilidades) {
		List<Turno> turnosGenerados = new ArrayList<>();

		for (Disponibilidad disponibilidad : disponibilidades) {
			DayOfWeek diaDisponibilidad = disponibilidadService.convertirADayOfWeek(disponibilidad.getDia());
			LocalDate fechaInicio = LocalDate.now();
			// GENERO TURNOS PARA UN MES
			LocalDate fechaFin = fechaInicio.plusWeeks(4);

			while (fechaInicio.isBefore(fechaFin)) {

				if (!fechaInicio.getDayOfWeek().equals(DayOfWeek.SUNDAY)
						&& fechaInicio.getDayOfWeek().equals(diaDisponibilidad)) {

					// RESTRINGIR HORARIO ANTERIOR A 8 AM
					LocalTime horaInicio = disponibilidad.getHoraInicio().isBefore(LocalTime.of(8, 0))
							? LocalTime.of(8, 0)
							: disponibilidad.getHoraInicio();

					// RESTRINGIR HORARIO POSTERIOR A 23 PM
					LocalTime horaFin = disponibilidad.getHoraFin().isAfter(LocalTime.of(23, 0)) ? LocalTime.of(23, 0)
							: disponibilidad.getHoraFin();
					while (horaInicio.isBefore(horaFin)) {
						Turno turnoGenerado = crearTurno(agenda, fechaInicio, horaInicio);
						turnosGenerados.add(turnoGenerado);

						// ASIGNO TURNOS CADA 1 HORA
						horaInicio = horaInicio.plusHours(1);
					}
				}
				fechaInicio = fechaInicio.plusDays(1);
			}
		}
		agendaRepository.save(agenda);
		return turnosGenerados;
	}

	private Turno crearTurno(Agenda agenda, LocalDate fecha, LocalTime hora) {
		Turno turno = new Turno();
		turno.setAgenda(agenda);
		turno.setFecha(fecha);
		turno.setHora(hora);
		turno.setEstado(Turno.EnEstado.Disponible);

		return turnoRepository.save(turno);
	}

	public List<Turno> obtenerTurnosDisponibles() {
		return turnoRepository.findAllByEstado(Turno.EnEstado.Disponible);
	}

	@Transactional
	public Map<String, Object> asignarTurno(AsignarTurnoDTO asignarTurnoDTO) {
		Map<String, Object> response = new HashMap<>();
		Paciente paciente = pacienteRepository.findByCuil(asignarTurnoDTO.getCuil());

		if (paciente != null) {
			Optional<Turno> turno = turnoRepository.findById(asignarTurnoDTO.getIdTurno());
			if (turno.isPresent()) {
				turno.get().setPaciente(paciente);
				turno.get().setEstado(Turno.EnEstado.Confirmado);
				turnoRepository.save(turno.get());
				response.put("msg", "Se asigno este turno al paciente: " + asignarTurnoDTO.getCuil());
			} else {
				response.put("msg", "Ese turno no existe ");
			}
		} else {
			response.put("msg", "No existe un paciente con ese cuil: " + asignarTurnoDTO.getCuil());
		}

		return response;
	}

	@Transactional
	public Map<String, Object> cancelarTurno(AsignarTurnoDTO asignarTurnoDTO) {
		Map<String, Object> response = new HashMap<>();
		Paciente paciente = pacienteRepository.findByCuil(asignarTurnoDTO.getCuil());

		if (paciente != null) {
			Optional<Turno> turno = turnoRepository.findById(asignarTurnoDTO.getIdTurno());
			if (turno.isPresent()) {
				turno.get().setPaciente(null);
				turno.get().setEstado(Turno.EnEstado.Cancelado);
				turnoRepository.save(turno.get());
				response.put("msg", "Se cancelo este turno al paciente: " + asignarTurnoDTO.getCuil());
			} else {
				response.put("msg", "No existe ese turno para ese paciente. ");
			}
		} else {
			response.put("msg", "No existe un paciente con ese cuil: " + asignarTurnoDTO.getCuil());
		}

		return response;

	}

	@Transactional
	public Map<String, Object> modificarTurno(ModificarTurnoDTO modificarTurnoDTO) {
		Map<String, Object> response = new HashMap<>();

		Optional<Turno> turno = turnoRepository.findById(modificarTurnoDTO.getId());
		if (turno.isPresent()) {
			Turno turnoModificado = turno.get();

			turnoModificado.setFecha(modificarTurnoDTO.getFecha());
			turnoModificado.setHora(modificarTurnoDTO.getHora());
			turnoModificado.setEstado(Turno.EnEstado.Modificado);

			turnoRepository.save(turnoModificado);
			response.put("msg", "Se modifico los datos del turno. ");
		} else {
			response.put("msg", "El turno no existe. ");
		}

		return response;

	}

}
