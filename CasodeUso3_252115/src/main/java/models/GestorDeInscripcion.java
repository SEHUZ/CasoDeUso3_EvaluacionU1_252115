/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import excepciones.InscripcionException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonic
 */
public class GestorDeInscripcion {

    private List<Taller> talleres = new ArrayList<>();
    private List<Alumno> alumnos = new ArrayList<>();
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public GestorDeInscripcion() {
        talleres.add(new Taller("001", "Taller de Diseño de Software", "Christian Gibran Duran Solano", LocalDate.of(2025, 10, 14), "10:00 - 12:00", "Aprenderas todo lo relacionado con UML"));
        talleres.add(new Taller("002", "Taller de la semana de ISW", "Carlos Alberto", LocalDate.of(2025, 10, 11), "12:00 - 14:00", "Creación de apps con MVC"));
        talleres.add(new Taller("003", "Taller de aplicaciones web", "Christian Gibran Duran Solano", LocalDate.of(2025, 10, 15), "9:00 - 10:00", "Creación de apps con MVC"));
        talleres.add(new Taller("004", "Taller de metodos numericos", "Juan Manuel Quiñonez Lopez", LocalDate.of(2025, 10, 12), "8:00 - 11:00", "Aprende a resolver matrices utilizando metodos como Gauss Jordan"));
        talleres.add(new Taller("005", "Taller de la vida", "Ing. Lopez Romo", LocalDate.of(2025, 10, 15), "14:00 - 16:00", "Aprende sobre la vida del ingeniero promedio"));

        alumnos.add(new Alumno("252115", "Sebastian", "Borquez", "Huerta", 5, "Ingenieria en Software"));
        alumnos.add(new Alumno("252116", "Ariel", "Borbon", "Izaguirre", 5, "Ingenieria en Software"));
    }

    public Taller obtenerTallerPorNombre(String nombre) {
        for (Taller taller : talleres) {
            if (taller.getNombreTaller().equalsIgnoreCase(nombre)) {
                return taller;
            }
        }
        return null;
    }

    public List<Taller> obtenerTalleresDisponibles() {
        return talleres;
    }

    public Alumno obtenerAlumnoPorId(String id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getIdAlumno().equalsIgnoreCase(id)) {
                return alumno;
            }
        }
        return null;
    }

    public Inscripcion inscribirAlumno(Alumno alumno, Taller taller) throws InscripcionException {
        if (alumno == null || taller == null) {
            throw new InscripcionException("Alumno o taller no válido");
        }

        if (yaEstaInscrito(alumno, taller)) {
            throw new InscripcionException("El alumno " + alumno.getNombreCompleto() + " ya está inscrito en este taller.");
        }

        Inscripcion inscripcion = new Inscripcion("I-" + System.currentTimeMillis(), alumno, taller, LocalDateTime.now());
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public boolean yaEstaInscrito(Alumno alumno, Taller taller) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getAlumno().getIdAlumno().equals(alumno.getIdAlumno())
                    && inscripcion.getTaller().getIdTaller().equals(taller.getIdTaller())) {
                return true;
            }
        }
        return false;
    }

    public String mostrarTicket(Inscripcion inscripcion) {
        return "TICKET DE INSCRIPCIÓN\n"
                + "Folio: " + inscripcion.getFolio() + "\n"
                + "Alumno: " + inscripcion.getAlumno().getNombreCompleto() + "\n"
                + "Taller: " + inscripcion.getTaller().getNombreTaller() + "\n"
                + "Fecha inscripción: " + inscripcion.getFechaInscripcion() + "\n";
    }

}
