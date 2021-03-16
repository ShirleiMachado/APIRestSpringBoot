package com.vacinas.restApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacinas.restApi.Models.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{
	
}
