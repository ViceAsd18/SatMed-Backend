package com.satmed.tratamiento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.tratamiento.models.entities.Tratamiento;

@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Integer>{
    
    // Buscar todos los tratamientos vinculados a una consulta médica
    List<Tratamiento> findByIdAtencionMedica(Integer idAtencionMedica);

}
