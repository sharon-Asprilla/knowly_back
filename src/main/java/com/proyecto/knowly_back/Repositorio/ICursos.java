package com.proyecto.knowly_back.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.knowly_back.Modelo.MCursos;

@Repository
public interface ICursos extends JpaRepository<MCursos,String> {
    List<MCursos> findByNombreCursos(String nombre);
    List<MCursos> findByDescripcion(String descripcion);
    List<MCursos> findByDuracion(String duracion);
}
