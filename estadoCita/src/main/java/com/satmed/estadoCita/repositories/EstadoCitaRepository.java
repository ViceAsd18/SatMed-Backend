package com.satmed.estadoCita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.estadoCita.models.entities.EstadoCita;

@Repository
public interface EstadoCitaRepository extends JpaRepository<EstadoCita, Integer> {
    
}
