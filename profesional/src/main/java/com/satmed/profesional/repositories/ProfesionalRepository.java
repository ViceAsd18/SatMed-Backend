package com.satmed.profesional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satmed.profesional.models.entities.Profesional;


public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {

    boolean existsByIdUsuario(Integer idUsuario);
    boolean existsByNumeroRegistroProfesional(String numeroRegistroProfesional);


}
