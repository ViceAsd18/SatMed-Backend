package com.satmed.alergias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.alergias.models.entities.Alergia;

@Repository
public interface AlergiaRepository extends JpaRepository <Alergia, Integer> {
    
}
