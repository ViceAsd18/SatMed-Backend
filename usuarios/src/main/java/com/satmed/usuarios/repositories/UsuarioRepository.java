package com.satmed.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satmed.usuarios.models.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Usuario findByRutUsuario(String rutUsuario);

    Usuario findByEmailUsuario(String emailUsuario);

}
