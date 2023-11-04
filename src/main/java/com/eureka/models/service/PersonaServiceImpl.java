package com.eureka.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eureka.models.dao.PersonaDao;
import com.eureka.models.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private PersonaDao personaDao;
	
	@Override
	@Transactional
	public List<Persona> getAllPersonas() {
		return (List<Persona>) personaDao.findAll();
	}

	@Override
	@Transactional
	public Persona getPersonaById(Long id) {
		return personaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona createPersona(Persona persona) {
		return personaDao.save(persona);
	}

}
