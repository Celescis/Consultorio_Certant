package com.cisternas.consultorio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisternas.consultorio.dto.ConsultorioDTO;
import com.cisternas.consultorio.dto.ConsultorioMapper;
import com.cisternas.consultorio.model.Consultorio;
import com.cisternas.consultorio.repository.ConsultorioRepository;

@RestController
@RequestMapping("/con")
public class ConsultorioController {
	
	@Autowired
	ConsultorioRepository consultorioRepository;

	@Autowired
	ConsultorioMapper consultorioMapper;
	
	// GET - UN CONSULTORIO
		@GetMapping("/get/{id}")
		public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
			try {
				Optional<Consultorio> consultorio = consultorioRepository.findById(id);
				if (consultorio.isPresent()) {
					return new ResponseEntity<>(consultorio, HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Consultorio no encontrado. ", HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				return new ResponseEntity<>("Error obteniendo el consultorio: " + e.getMessage(),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		// GET - LISTA DE CONSULTORIOS
		@GetMapping
		public ResponseEntity<?> obtenerLista() {
			try {

				List<Consultorio> consultorios = (List<Consultorio>) consultorioRepository.findAll();
				if (consultorios.isEmpty()) {
					return new ResponseEntity<String>("No se encontraron consultorios. ", HttpStatus.NO_CONTENT);
				} else {
					return new ResponseEntity<List<ConsultorioDTO>>(consultorioMapper.lstEntityToLstDto(consultorios),
							HttpStatus.OK);
				}

			} catch (Exception e) {
				return new ResponseEntity<String>("Error obteniendo la lista de consultorios: " + e.getMessage(),
						HttpStatus.BAD_REQUEST);
			}
		}

		// POST - CREAR UN CONSULTORIO
		 @PostMapping("/post")
		    public ResponseEntity<?> crear() {
		        try {
		        	Consultorio nuevoConsultorio = new Consultorio();
		        	
		            consultorioRepository.save(nuevoConsultorio);
		            return new ResponseEntity<>(nuevoConsultorio, HttpStatus.CREATED);
		        } catch (Exception e) {
		            return new ResponseEntity<>("Error al crear el consultorio: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		        }
		    }

		// DELETE - BORRAR UN CONSULTORIO
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<?> eliminar(@PathVariable Long id) {
			try {
				Optional<Consultorio> consultorio = consultorioRepository.findById(id);
				if (consultorio.isPresent()) {

					consultorioRepository.delete(consultorio.get());

					return new ResponseEntity<String>("Se elimino el consultorio: " + id, HttpStatus.OK);

				} else {

					return new ResponseEntity<String>("Consultorio no encontrado: ", HttpStatus.NOT_FOUND);
				}

			} catch (Exception e) {
				return new ResponseEntity<String>("Error eliminando el consultorio: " + e.getMessage(),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}
}
