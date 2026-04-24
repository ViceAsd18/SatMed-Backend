package com.satmed.profesional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satmed.profesional.model.entities.Profesional;

public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {
}
