package com.satmed.fichaClinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.fichaClinica.models.entities.FichaClinica;

@Repository
public interface FichaClinicaRepository extends JpaRepository <FichaClinica,Integer> {
    
    boolean existsByIdPaciente(Integer idPaciente);

    FichaClinica findByIdPaciente(Integer idPaciente);

}
