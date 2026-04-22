package com.satmed.genero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.genero.models.entities.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
    
}

