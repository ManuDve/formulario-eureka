package com.eureka.models.entity;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "personas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false, unique = true)
	private String email;
	@ManyToOne
	@JoinColumn(name= "departamento_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Departamento departamento;
	@Column(name = "area")
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private String nombreDepartamento;
	
	public String getNombreDepartamento() {
		nombreDepartamento = departamento.getNombre();
		return nombreDepartamento;
	}

	public void setNombreDepartamento() {
		this.nombreDepartamento = departamento.getNombre();
	}

	/*@JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("area")
	public String getNombreDepartamento() {
        if (departamento != null) {
            return departamento.getNombre();
        }
        return null;
    }
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1188377604680122522L;
}
