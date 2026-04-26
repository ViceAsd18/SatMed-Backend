package com.satmed.tipoPublicacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.tipoPublicacion.models.entities.TipoPublicacion;

@Repository
public interface TipoPublicacionRepository extends JpaRepository<TipoPublicacion, Integer> {

}
