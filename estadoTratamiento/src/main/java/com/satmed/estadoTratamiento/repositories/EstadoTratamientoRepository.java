package com.satmed.estadoTratamiento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.estadoTratamiento.models.entities.EstadoTratamiento;

@Repository
public interface EstadoTratamientoRepository extends JpaRepository<EstadoTratamiento, Integer> {

}
