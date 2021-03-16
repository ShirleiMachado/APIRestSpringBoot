package com.vacinas.restApi.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Vacinas {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "campo.nome.obrigatorio")
	@Column(nullable = false)
	private String nomeVacina;
	private String nomeUsuario;
	@NotEmpty(message = "campo.email.obrigatorio")
	@Column(unique = true)
	private String email;
	
	
	
}
