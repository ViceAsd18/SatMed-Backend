package com.satmed.EnfermedadCronica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.EnfermedadCronica.models.entities.EnfermedadCronica;

@Repository
public interface EnfermedadCronicaRepository extends JpaRepository<EnfermedadCronica, Integer>{
    
}
