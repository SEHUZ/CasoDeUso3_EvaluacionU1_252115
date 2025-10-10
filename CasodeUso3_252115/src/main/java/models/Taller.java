/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author sonic
 */
public class Taller {
    
    private String idTaller;
    private String nombreTaller;
    private String nombreInstructor;
    private LocalDate fecha;
    private String horario;
    private String descripcion;

    public Taller(String idTaller, String nombreTaller, String nombreInstructor, LocalDate fecha, String horario, String descripcion) {
        this.idTaller = idTaller;
        this.nombreTaller = nombreTaller;
        this.nombreInstructor = nombreInstructor;
        this.fecha = fecha;
        this.horario = horario;
        this.descripcion = descripcion;
    }

    public Taller() {
    }

    public String getIdTaller() {
        return idTaller;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public String getNombreInstructor() {
        return nombreInstructor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getHorario() {
        return horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Taller{" + "idTaller=" + idTaller + ", nombreTaller=" + nombreTaller + ", nombreInstructor=" + nombreInstructor + ", fecha=" + fecha + ", horario=" + horario + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
