package com.proyecto.knowly_back.Repositorio;

import com.proyecto.knowly_back.Modelo.MUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuario extends JpaRepository<MUsuario,String> {
    List<MUsuario> findByNombre(String Nombre);

    // Buscar usuarios por rol
    List<MUsuario> findByRol(String rol);

}
