package com.cisternas.consultorio.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cisternas.consultorio.model.Agenda;
import com.cisternas.consultorio.model.Disponibilidad;
import com.cisternas.consultorio.model.Turno;
import com.cisternas.consultorio.repository.AgendaRepository;
import com.cisternas.consultorio.repository.TurnoRepository;

@Service
public class TurnoService {
	@Autowired
	private TurnoRepository turnoRepository;

	@Autowired
	private DisponibilidadService disponibilidadService;

	@Autowired
	private AgendaRepository agendaRepository;

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

}
