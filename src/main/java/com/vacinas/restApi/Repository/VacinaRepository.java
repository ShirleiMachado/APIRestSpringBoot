package com.vacinas.restApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacinas.restApi.Models.Vacinas;

public interface VacinaRepository extends JpaRepository<Vacinas, Integer> {

}
