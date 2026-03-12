package com.proyecto.knowly_back.Repositorio;

import com.proyecto.knowly_back.Modelo.MUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario<integer> extends JpaRepository<MUsuario,String> {
}
