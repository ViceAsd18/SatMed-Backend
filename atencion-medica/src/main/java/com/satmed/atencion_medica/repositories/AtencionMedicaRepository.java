package com.satmed.atencion_medica.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.atencion_medica.models.entities.AtencionMedica;

import java.util.List;

@Repository
public interface AtencionMedicaRepository extends JpaRepository<AtencionMedica, Long> {
    List<AtencionMedica> findByIdPaciente(Long idPaciente);
}
