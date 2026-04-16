package com.proyecto.knowly_back.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "inscripciones")
public class MInscripciones {




        @Id
        @Column(length = 10,nullable = false)
        String ideInscripciones;

        @Column (length = 10,nullable = false)
        String ideUsuario;

        @Column (length = 10,nullable = false)
        String ideCurso;

        @Column(nullable = false)
        LocalDate fechaInscripcion;

        //relaciones

        //constructores
        public MInscripciones(String ideInscripciones, String ideUsuario, String ideCurso, LocalDate fechaInscripcion) {
            this.ideInscripciones = ideInscripciones;
            this.ideUsuario = ideUsuario;
            this.ideCurso = ideCurso;
            this.fechaInscripcion = fechaInscripcion;
        }

        public MInscripciones() {
        }

        //encapsulamiento


        public String getIdeInscripciones() {
            return ideInscripciones;
        }

        public void setIdeInscripcion(String ideInscripcion) {
            this.ideInscripciones = ideInscripcion;
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
