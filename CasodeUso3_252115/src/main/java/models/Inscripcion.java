/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author sonic
 */
public class Inscripcion {
    
    private String folio;
    private Alumno alumno;
    private Taller taller;
    private LocalDateTime fechaInscripcion;
    
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Inscripcion(String folio, Alumno alumno, Taller taller, LocalDateTime fechaInscripcion) {
        this.folio = folio;
        this.alumno = alumno;
        this.taller = taller;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Inscripcion() {
    }

    public String getFolio() {
        return folio;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Taller getTaller() {
        return taller;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }
    
    public String getFechaInscripcionFormateada() {
        return fechaInscripcion.format(FORMATO_FECHA);
    }
    
    
    
}
