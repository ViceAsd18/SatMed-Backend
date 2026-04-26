package com.satmed.cita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.cita.models.entities.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
}
