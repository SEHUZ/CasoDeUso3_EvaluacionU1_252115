/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.entitys;

/**
 *
 * @author sonic
 */
public class Alumno {

    private String idAlumno;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int semestre;
    private String programaEducativo;

    public Alumno(String idAlumno, String nombre, String apellidoPaterno, String apellidoMaterno, int semestre, String programaEducativo) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.semestre = semestre;
        this.programaEducativo = programaEducativo;
    }

    public Alumno() {
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

    public String getNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

}
