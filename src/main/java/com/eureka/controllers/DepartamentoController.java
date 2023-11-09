package com.eureka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.models.entity.Departamento;
import com.eureka.models.service.IDepartamentoService;

@RestController
@RequestMapping("api/departamentos")
public class DepartamentoController {
	@Autowired
	private IDepartamentoService departamentoService;
	
	@GetMapping
	@CrossOrigin
	public List<Departamento> listarDepartamentos(){
		return departamentoService.getAllDepartamentos();
	}
	@GetMapping("/{id}")
	@CrossOrigin
	public Departamento obtenerDepartamentoPorId(@PathVariable("id") Long id) {
		return departamentoService.getDepartamentoById(id);
	}
	@PostMapping
	public Departamento crearDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.createDepartamento(departamento);
	}
}
