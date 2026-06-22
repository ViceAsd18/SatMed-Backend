package com.satmed.horarioProfesional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.satmed.horarioProfesional.models.entities.DiaSemana;

@Repository
public interface DiaSemanaRepository extends JpaRepository<DiaSemana, Long> {
    
}