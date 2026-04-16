package com.proyecto.knowly_back.Repositorio;

import com.proyecto.knowly_back.Modelo.MCursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICursos extends JpaRepository<MCursos,String> {
    List<MCursos> findByNombreCursos(String nombre);
    List<MCursos> findByDescripcion(String descripcion);
    List<MCursos> findByDuracion(String nombre, String descripcion);


}
