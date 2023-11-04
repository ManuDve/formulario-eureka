package com.eureka.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eureka.models.dao.DepartamentoDao;
import com.eureka.models.entity.Departamento;

import jakarta.transaction.Transactional;

@Service
public class DepartamentoImpl implements IDepartamentoService {
	
	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Transactional
	@Override
	public List<Departamento> getAllDepartamentos() {
		return (List<Departamento>) departamentoDao.findAll();
	}
	
	@Transactional
	@Override
	public Departamento getDepartamentoById(Long id) {
		return departamentoDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Departamento createDepartamento(Departamento departamento) {
		return departamentoDao.save(departamento);
	}

}
