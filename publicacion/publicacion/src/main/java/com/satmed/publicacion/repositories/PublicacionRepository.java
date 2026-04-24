package com.satmed.publicacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satmed.publicacion.models.entities.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}


