package com.satmed.atencion_medica.repositories;

import com.satmed.atencion_medica.models.entities.Interconsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InterconsultaRepository extends JpaRepository<Interconsulta, Long> {
    List<Interconsulta> findByAtencionMedicaIdAtencion(Long idAtencion);
    
    List<Interconsulta> findByIdProfesional(Long idProfesional);
}