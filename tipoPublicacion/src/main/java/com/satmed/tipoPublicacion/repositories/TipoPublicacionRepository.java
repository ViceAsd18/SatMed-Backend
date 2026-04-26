package com.satmed.tipoPublicacion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.tipoPublicacion.models.entities.TipoPublicacion;

@Repository
public interface TipoPublicacionRepository extends JpaRepository<TipoPublicacion, Integer> {

    //busca coincidencias parciales (como un buscador) e ignora mayúsculas/minúsculas
    List<TipoPublicacion> findByNombreTipoPublicacionContainingIgnoreCase(String nombre);

}
