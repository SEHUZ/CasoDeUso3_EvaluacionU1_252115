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
 *
 * Controlador principal para manejar las operaciones de inscripción en la
 * aplicación.
 */
public class ControlInscripcion {

    private GestorDeInscripcion gestor;

    public ControlInscripcion(GestorDeInscripcion gestor) {
        this.gestor = gestor;
    }

    /**
     * Obtiene la lista de talleres disponibles delegando la tarea al modelo sin
     * validaciones
     *
     * @return Lista de Talleres disponibles.
     */
    public List<Taller> obtenerTalleres() {
        return gestor.obtenerTalleresDisponibles();
    }

    /**
     * Busca un alumno por su id validando el input antes de consultar el modelo
     *
     * @param idAlumno id del alumno a buscar
     * @return El alumno encontrado.
     * @throws InscripcionException si el id es invalido o no se encuentra el
     * alumno.
     */
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

    /**
     * Registra una nueva inscripción delegando la responsabilidad al modelo
     *
     * @param alumno El alumno a inscribir y encontrado
     * @param taller El taller seleccionado.
     * @return La Inscripcion registrada.
     * @throws InscripcionException
     */
    public Inscripcion registrarInscripcion(Alumno alumno, Taller taller) throws InscripcionException {
        return gestor.inscribirAlumno(alumno, taller);
    }

    /**
     * Genera el ticket de inscripción como String, listo para ser mostrado en la Vista.
     * Delega la generación al modelo, pero el controlador coordina el flujo post-inscripción.
     * 
     * @param inscripcion La inscripción recién creada.
     * @return String formateado del ticket (para impresión o display en UI).
     */
    public String generarTicket(Inscripcion inscripcion) {
        return gestor.mostrarTicket(inscripcion);
    }
}
