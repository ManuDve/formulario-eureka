package com.eureka.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.eureka.models.service.IDepartamentoService;

@SpringBootTest
@AutoConfigureMockMvc
class DepartamentoControllerTest {
	
	private static final String PATH_URL = "/api/departamentos";
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IDepartamentoService departamentoService;
	
	@Test
	void testListarDepartamentos() throws Exception {
		// Funciona gracias al import.sql con datos previamente cargados
		mvc.perform(MockMvcRequestBuilders.get(PATH_URL))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

	@Test
	void testObtenerDepartamentoPorIdString() throws Exception {
		String nuevaId = "ejemplo"; 
		// No funciona porque debe pasar una ID numerica
		mvc.perform(MockMvcRequestBuilders.get(PATH_URL+ "/" + nuevaId ))
		.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}
	
	@Test
	void testObtenerDepartamentoPorIdNumerica() throws Exception {
		Number nuevaId = 3; 
		// Funciona porque debe pasar una ID numerica
		mvc.perform(MockMvcRequestBuilders.get(PATH_URL+ "/" + nuevaId ))
		.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}


	

}
