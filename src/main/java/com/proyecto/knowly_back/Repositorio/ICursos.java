package com.proyecto.knowly_back.Repositorio;

import com.proyecto.knowly_back.Modelo.MCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursos extends JpaRepository<MCurso,String> {
}
