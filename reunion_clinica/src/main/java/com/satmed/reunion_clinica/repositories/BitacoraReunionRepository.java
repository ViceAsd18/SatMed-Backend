package com.satmed.reunion_clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.reunion_clinica.models.entities.BitacoraReunion;

import java.util.List;

@Repository
public interface BitacoraReunionRepository extends JpaRepository<BitacoraReunion, Long> {
    
    List<BitacoraReunion> findByReunionClinicaIdReunion(Long idReunion);
}