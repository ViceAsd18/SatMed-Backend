package com.satmed.reunion_clinica.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.reunion_clinica.models.entities.ReunionClinica;

@Repository
public interface ReunionClinicaRepository extends JpaRepository<ReunionClinica, Long> {

}   