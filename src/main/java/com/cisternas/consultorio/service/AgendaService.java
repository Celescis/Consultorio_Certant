package com.cisternas.consultorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cisternas.consultorio.model.Agenda;
import com.cisternas.consultorio.model.Profesional;
import com.cisternas.consultorio.repository.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository agendaRepository;

	@Transactional
	public Agenda generarAgenda(Profesional profesional) {
		final Agenda agenda = new Agenda();
		agenda.setProfesional(profesional);

		return agendaRepository.save(agenda);
	}

}
