/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import models.entitys.Alumno;
import models.entitys.Taller;
import models.dtos.AlumnoDTO;
import models.dtos.TallerDTO;

/**
 *
 * @author sonic
 */
public class InscripcionDTO {
    
    private String folio;
    private AlumnoDTO alumno;
    private TallerDTO taller;
    private LocalDateTime fechaInscripcion;
    

    public InscripcionDTO(String folio, AlumnoDTO alumno, TallerDTO taller, LocalDateTime fechaInscripcion) {
        this.folio = folio;
        this.alumno = alumno;
        this.taller = taller;
        this.fechaInscripcion = fechaInscripcion;
    } 
    

    public String getFolio() {
        return folio;
    }

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public TallerDTO getTaller() {
        return taller;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }


    @Override
    public String toString() {
        return "InscripcionDTO{" + "folio=" + folio + ", alumno=" + alumno + ", taller=" + taller + ", fechaInscripcion=" + fechaInscripcion + '}';
    }
    
    
    
}
