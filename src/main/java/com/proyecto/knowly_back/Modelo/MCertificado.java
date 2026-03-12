package com.proyecto.knowly_back.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "certificado")
public class MCertificado {
    @Id
    @Column(length = 10, nullable = false)
    String idCertificado;

    @Column(length = 10, nullable = false)
    String ideUsuario;

    @Column(length = 10, nullable = false)
    String idCurso;

    @Column(nullable = false)
    LocalDate fechaEmision;

    //relaciones

    //constructores


    public MCertificado(String idCertificado, String ideUsuario, String idCurso, LocalDate fechaEmision) {
        this.idCertificado = idCertificado;
        this.ideUsuario = ideUsuario;
        this.idCurso = idCurso;
        this.fechaEmision = fechaEmision;
    }

    public MCertificado() {
    }

    //encapsulamiento


    public String getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(String idCertificado) {
        this.idCertificado = idCertificado;
    }

    public String getIdeUsuario() {
        return ideUsuario;
    }

    public void setIdeUsuario(String ideUsuario) {
        this.ideUsuario = ideUsuario;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
