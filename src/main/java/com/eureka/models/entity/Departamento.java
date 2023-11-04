package com.eureka.models.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "departamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamento implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nombre;
	@Column(name = "cantidad_empleados")
	
	@Getter(AccessLevel.NONE)
	private int cantidadEmpleados = 0;
	@OneToMany(
			mappedBy = "departamento",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	@JsonIgnoreProperties("departamento")
	private List<Persona> listaEmpleados;
	
 
	public Integer getCantidadEmpleados() {
		if(listaEmpleados != null) {
			cantidadEmpleados = listaEmpleados.size();
		}
		return cantidadEmpleados;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 2715489243520989286L;
}
