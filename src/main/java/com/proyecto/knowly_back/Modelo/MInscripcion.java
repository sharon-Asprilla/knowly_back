package com.proyecto.knowly_back.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
public class MInscripcion {

    @Id
    @Column(length = 10,nullable = false)
    String ideInscripcion;

    @Column (length = 10,nullable = false)
    String ideUsuario;

    @Column (length = 10,nullable = false)
    String ideCurso;

    @Column(nullable = false)
    LocalDate fechaInscripcion;

    //relaciones

    //constructores


    public MInscripcion(String ideInscripcion, String ideUsuario, String ideCurso, LocalDate fechaInscripcion) {
        this.ideInscripcion = ideInscripcion;
        this.ideUsuario = ideUsuario;
        this.ideCurso = ideCurso;
        this.fechaInscripcion = fechaInscripcion;
    }

    public MInscripcion() {
    }

    //encapsulamiento


    public String getIdeInscripcion() {
        return ideInscripcion;
    }

    public void setIdeInscripcion(String ideInscripcion) {
        this.ideInscripcion = ideInscripcion;
    }

    public String getIdeUsuario() {
        return ideUsuario;
    }

    public void setIdeUsuario(String ideUsuario) {
        this.ideUsuario = ideUsuario;
    }

    public String getIdeCurso() {
        return ideCurso;
    }

    public void setIdeCurso(String ideCurso) {
        this.ideCurso = ideCurso;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
