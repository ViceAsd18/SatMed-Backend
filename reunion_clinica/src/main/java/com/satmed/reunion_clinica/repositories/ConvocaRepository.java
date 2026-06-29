package com.satmed.reunion_clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.satmed.reunion_clinica.models.entities.Convoca;
import com.satmed.reunion_clinica.models.entities.ConvocaId;

import com.satmed.reunion_clinica.models.entities.Convoca;
import com.satmed.reunion_clinica.models.entities.ConvocaId;


@Repository
public interface ConvocaRepository extends JpaRepository<Convoca,ConvocaId> {
    
    List<Convoca> findByIdIdReunion(Long idReunion);
    
    List<Convoca> findByIdIdProfesional(Long idProfesional);
}