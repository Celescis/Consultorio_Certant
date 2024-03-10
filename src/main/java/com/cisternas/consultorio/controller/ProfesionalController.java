package com.cisternas.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisternas.consultorio.dto.ProfesionalDTO;
import com.cisternas.consultorio.dto.ProfesionalMapper;
import com.cisternas.consultorio.model.Profesional;
import com.cisternas.consultorio.repository.ProfesionalRepository;
import com.cisternas.consultorio.service.ProfesionalService;

@RestController
@RequestMapping("/pro")
public class ProfesionalController {

}
