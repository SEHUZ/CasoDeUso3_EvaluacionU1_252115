/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dtos;

/**
 *
 * @author sonic
 */
public class AlumnoDTO {

    private String idAlumno;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int semestre;
    private String programaEducativo;

    public AlumnoDTO(String idAlumno, String nombre, String apellidoPaterno, String apellidoMaterno, int semestre, String programaEducativo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.semestre = semestre;
        this.programaEducativo = programaEducativo;
    }

    public String getIdAlumno() {
        return idAlumno;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", semestre=" + semestre + ", programaEducativo=" + programaEducativo + '}';
    }
    
    

}
