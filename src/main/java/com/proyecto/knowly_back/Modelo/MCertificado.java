package com.proyecto.knowly_back.Modelo;

import java.time.LocalDate;


import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificado")
public class MCertificado {

    @Id
    @Column(name = "id_certificado", length = 10, nullable = false)
    private String idCertificado;   // único identificador de la entidad

    @Column(nullable = false)
    private LocalDate fechaEmision;

    // Relación: certificado → usuario
    @ManyToOne
    @JoinColumn(name = "ideusuario", nullable = false) // FK hacia usuario
    @JsonBackReference
    private MUsuario mUsuario;

    // Relación: certificado → curso
    @ManyToOne
    @JoinColumn(name = "idecurso", nullable = false) // FK hacia curso
    @JsonBackReference
    private MCursos mCurso;

    // Campo adicional (no es @Id, solo columna)
    @Column(name = "id_interno")
    private Long id;

    // Constructores
    public MCertificado() {}

    public MCertificado(String idCertificado, LocalDate fechaEmision, MUsuario mUsuario, MCursos mCurso, Long id) {
        this.idCertificado = idCertificado;
        this.fechaEmision = fechaEmision;
        this.mUsuario = mUsuario;
        this.mCurso = mCurso;
        this.id = id;
    }

    // Getters y setters
    public String getIdCertificado() { return idCertificado; }
    public void setIdCertificado(String idCertificado) { this.idCertificado = idCertificado; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public MUsuario getMUsuario() { return mUsuario; }
    public void setMUsuario(MUsuario mUsuario) { this.mUsuario = mUsuario; }

    public MCursos getMCurso() { return mCurso; }
    public void setMCurso(MCursos mCurso) { this.mCurso = mCurso; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}