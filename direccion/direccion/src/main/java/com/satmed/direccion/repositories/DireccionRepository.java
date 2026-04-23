package com.satmed.direccion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satmed.direccion.models.entities.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
}
