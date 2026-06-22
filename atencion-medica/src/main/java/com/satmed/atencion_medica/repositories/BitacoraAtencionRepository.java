package com.satmed.atencion_medica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.atencion_medica.models.entities.BitacoraAtencion;

import java.util.List;

@Repository
public interface BitacoraAtencionRepository extends JpaRepository<BitacoraAtencion, Long> {
    List<BitacoraAtencion> findByAtencionMedicaIdAtencion(Long idAtencion);
}
