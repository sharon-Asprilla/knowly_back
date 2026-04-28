package com.proyecto.knowly_back.Repositorio;

import java.util.List;

import com.proyecto.knowly_back.Modelo.MInscripciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IInscripciones extends JpaRepository<MInscripciones,String> {

    @Query(value = "select I.id_inscripcion as id_inscripcion, U.nombre as nombre, U.apellido as apellido, " +
            "U.documento as documento, U.correo as correo " +
            "from inscripciones I inner join usuario U " +
            "on I.ideusuario = U.ideusuario where U.documento = :documento", nativeQuery = true)
    List<MInscripciones> buscarInscripciones(@Param("documento") String documento);
}
