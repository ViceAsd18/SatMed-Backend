package com.satmed.horarioProfesional.repositories;

import com.satmed.horarioProfesional.models.entities.HorarioProfesional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioProfesionalRepository extends JpaRepository<HorarioProfesional, Long> {

    List<HorarioProfesional> findByIdProfesional(Long idProfesional);
}
