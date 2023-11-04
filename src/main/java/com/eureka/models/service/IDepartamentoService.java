package com.eureka.models.service;

import java.util.List;

import com.eureka.models.entity.Departamento;

public interface IDepartamentoService {
	public List<Departamento> getAllDepartamentos();
	public Departamento getDepartamentoById(Long id);
	public Departamento createDepartamento(Departamento departamento);
	
}
