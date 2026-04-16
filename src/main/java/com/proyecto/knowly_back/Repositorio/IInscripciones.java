package com.proyecto.knowly_back.Repositorio;

import com.proyecto.knowly_back.Modelo.MInscripciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IInscripciones extends JpaRepository<MInscripciones,String> {

    @Query(value = "select I.ideUsuario as ideUsuario, U.nombre as nombre, U.apellido as apellido, " +
            "I.documento as documento, U.correo as correo " +
            "from inscripciones I inner join usuario U " +
            "on I.ideusuario = U.ideusuario where I.ideusuario = documento", nativeQuery = true)
    List<IInscripciones> buscarInscripciones(@Param("documento") String documento);
}
