/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import excepciones.InscripcionException;
import java.util.List;
import models.Alumno;
import models.GestorDeInscripcion;
import models.Inscripcion;
import models.Taller;

/**
 *
 * @author sonic
 */
public class ControlInscripcion {
    
    private GestorDeInscripcion gestor;

    public ControlInscripcion(GestorDeInscripcion gestor) {
        this.gestor = gestor;
    }

    public List<Taller> obtenerTalleres() {
        return gestor.obtenerTalleresDisponibles();
    }

    public Alumno buscarAlumnoPorId(String idAlumno) throws InscripcionException {
        if (idAlumno == null || idAlumno.isBlank()) {
            throw new InscripcionException("Debe ingresar un ID de alumno.");
        }

        Alumno alumno = gestor.obtenerAlumnoPorId(idAlumno);
        if (alumno == null) {
            throw new InscripcionException("No se encontró un alumno con el ID: " + idAlumno);
        }

        return alumno;
    }

    public Inscripcion registrarInscripcion(Alumno alumno, Taller taller) throws InscripcionException {
        return gestor.inscribirAlumno(alumno, taller);
    }

    public String generarTicket(Inscripcion inscripcion) {
        return gestor.mostrarTicket(inscripcion);
    }
}
