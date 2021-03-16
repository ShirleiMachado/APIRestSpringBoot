package com.vacinas.restApi.Models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Usuario {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	@Column(nullable = false, length = 200)
	private String nome;
	@NotEmpty(message = "{campo.email.obrigatorio}")  
	@Column(unique = true)
	@Email(message ="{campo.email.obrigatorio}")
	private String email;
	@NotEmpty(message = "{campo.cpf.obrigatorio}")
	@Column(unique = true)
	@CPF(message ="{campo.cpf.invalido}")
	private String cpf;

	@Column(nullable = false, updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	
}
