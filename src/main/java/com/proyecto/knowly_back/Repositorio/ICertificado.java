package com.proyecto.knowly_back.Repositorio;

import com.proyecto.knowly_back.Modelo.MCertificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICertificado extends JpaRepository<MCertificado,String> {
}
