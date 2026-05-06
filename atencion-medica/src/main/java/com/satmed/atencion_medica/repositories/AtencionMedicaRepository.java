package com.satmed.atencion_medica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.atencion_medica.models.AtencionMedica;

@Repository
public interface  AtencionMedicaRepository extends  JpaRepository<AtencionMedica, Integer>{
    
}
