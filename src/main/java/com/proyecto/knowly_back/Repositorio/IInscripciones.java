package com.proyecto.knowly_back.Repositorio;

import com.proyecto.knowly_back.Modelo.MInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInscripciones  extends JpaRepository<MInscripcion,String> {
}
