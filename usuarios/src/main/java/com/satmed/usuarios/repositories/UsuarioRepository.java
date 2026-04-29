package com.satmed.usuarios.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.usuarios.models.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByRutUsuario(String rutUsuario);

    Optional<Usuario> findByEmailUsuario(String emailUsuario);

}
