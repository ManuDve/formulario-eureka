package com.eureka.models.service;

import java.util.List;

import com.eureka.models.entity.Persona;

public interface IPersonaService {
	public List<Persona> getAllPersonas();
	public Persona getPersonaById(Long id);
	public Persona createPersona(Persona persona);
}
