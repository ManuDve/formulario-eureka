package com.eureka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.models.entity.Departamento;
import com.eureka.models.entity.Persona;
import com.eureka.models.service.IDepartamentoService;
import com.eureka.models.service.IPersonaService;

@RestController
@RequestMapping("api/personas")
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IDepartamentoService departamentoService;
	
	@GetMapping
	public List<Persona> listarPersonas() {
		return personaService.getAllPersonas();
	}
	
	@GetMapping("/{id}")
	public Persona listarPersonaPorId(@PathVariable("id") Long id) {
		return personaService.getPersonaById(id);
	}
	
	@PostMapping
	public ResponseEntity<?> crearPersona(@RequestBody Persona persona) {
		Departamento departamentoReferenciado = departamentoService.getDepartamentoById(persona.getDepartamento().getId());
		persona.setDepartamento(departamentoReferenciado);
		persona.setNombreDepartamento();
		
		if (persona.getDepartamento() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Departamento incorrecto");
		}
		
		Integer numeroActualEmpleados = departamentoReferenciado.getCantidadEmpleados()+1;
		departamentoReferenciado.setCantidadEmpleados(numeroActualEmpleados++);
		
		personaService.createPersona(persona);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(persona);
	}

}
