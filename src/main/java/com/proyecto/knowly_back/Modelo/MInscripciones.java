package com.proyecto.knowly_back.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
public class MInscripciones {

    @Id
    @Column(length = 10, nullable = false)
    private String ideinscripcion;

    @Column(nullable = false)
    private LocalDate fechainscripcion;

    // Relación: inscripción → estudiante (usuario con rol ESTUDIANTE)
    @ManyToOne
    @JoinColumn(name = "ideusuario", nullable = false) // FK hacia usuario
    @JsonBackReference
    private MUsuario mUsuario;   // <-- coincide con mappedBy="mUsuario" en MUsuario

    // Relación: inscripción → curso
    @ManyToOne
    @JoinColumn(name = "idecurso", nullable = false) // FK hacia curso
    @JsonBackReference
    private MCursos mCurso;      // <-- coincide con mappedBy="mCurso" en MCursos

    // Constructores
    public MInscripciones() {
    }

    public MInscripciones(String ideinscripcion, LocalDate fechainscripcion, MUsuario mUsuario, MCursos mCurso) {
        this.ideinscripcion = ideinscripcion;
        this.fechainscripcion = fechainscripcion;
        this.mUsuario = mUsuario;
        this.mCurso = mCurso;
    }

    public String getIdeinscripcion() {
        return ideinscripcion;
    }

    public void setIdeinscripcion(String ideinscripcion) {
        this.ideinscripcion = ideinscripcion;
    }

    public LocalDate getFechainscripcion() {
        return fechainscripcion;
    }

    public void setFechainscripcion(LocalDate fechainscripcion) {
        this.fechainscripcion = fechainscripcion;
    }

    public MUsuario getmUsuario() {
        return mUsuario;
    }

    public void setmUsuario(MUsuario mUsuario) {
        this.mUsuario = mUsuario;
    }

    public MCursos getmCurso() {
        return mCurso;
    }

    public void setmCurso(MCursos mCurso) {
        this.mCurso = mCurso;
    }
}
