package com.satmed.estadoCita.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.estadoCita.models.entities.EstadoCita;

@Repository
public interface EstadoCitaRepository extends JpaRepository<EstadoCita, Integer> {
 
    // Buscamos por el nombre exacto de la propiedad en la entidad
    List<EstadoCita> findByNombreEstadoCitaContainingIgnoreCase(String nombre);

}
