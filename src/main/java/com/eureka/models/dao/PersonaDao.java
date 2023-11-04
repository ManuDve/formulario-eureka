package com.eureka.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eureka.models.entity.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long>{

}
