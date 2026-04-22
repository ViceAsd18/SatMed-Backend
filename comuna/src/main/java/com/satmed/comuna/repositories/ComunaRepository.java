package com.satmed.comuna.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.comuna.models.entities.Comuna;


@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Integer> {
    
    List<Comuna> findByIdRegion(Integer idRegion);


}
