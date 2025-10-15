/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import Observer.Observador;
import Observer.Sujeto;
import models.entitys.Alumno;
import models.entitys.Inscripcion;
import models.entitys.Taller;
import excepciones.InscripcionException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonic
 */
public class GestorDeInscripcion implements Sujeto {

    private List<Taller> talleres = new ArrayList<>();
    private List<Alumno> alumnos = new ArrayList<>();
    private List<Inscripcion> inscripciones = new ArrayList<>();

    private List<Observador> observadores = new ArrayList<>();

    /**
     * Constructor que inicializa datos de ejemplo
     */
    public GestorDeInscripcion() {
        //Crear talleres de ejemplo
        talleres.add(new Taller("001", "Taller de Diseño de Software", "Christian Gibran Duran Solano", LocalDate.of(2025, 10, 14), "10:00 - 12:00", "Aprenderas todo lo relacionado con UML"));
        talleres.add(new Taller("002", "Taller de la semana de ISW", "Carlos Alberto", LocalDate.of(2025, 10, 11), "12:00 - 14:00", "Creación de apps con MVC"));
        talleres.add(new Taller("003", "Taller de aplicaciones web", "Christian Gibran Duran Solano", LocalDate.of(2025, 10, 15), "9:00 - 10:00", "Creación de apps con MVC"));
        talleres.add(new Taller("004", "Taller de metodos numericos", "Juan Manuel Quiñonez Lopez", LocalDate.of(2025, 10, 12), "8:00 - 11:00", "Aprende a resolver matrices utilizando metodos como Gauss Jordan"));
        talleres.add(new Taller("005", "Taller de la vida", "Ing. Lopez Romo", LocalDate.of(2025, 10, 15), "14:00 - 16:00", "Aprende sobre la vida del ingeniero promedio"));

        //crear dos alumnos
        alumnos.add(new Alumno("252115", "Sebastian", "Borquez", "Huerta", 5, "Ingenieria en Software"));
        alumnos.add(new Alumno("252116", "Ariel", "Borbon", "Izaguirre", 5, "Ingenieria en Software"));
    }

    /**
     * Busca un taller por su nombre
     *
     * @param nombre Nombre del taller a buscar.
     * @return El Taller encontrado, o null si no existe.
     */
    public Taller obtenerTallerPorNombre(String nombre) {
        for (Taller taller : talleres) {
            if (taller.getNombreTaller().equalsIgnoreCase(nombre)) {
                return taller;
            }
        }
        return null;
    }

    /**
     * Obtiene la lista completa de talleres disponibles.
     *
     * @return Lista inmutable de Talleres
     */
    public List<Taller> obtenerTalleresDisponibles() {
        return talleres;
    }

    /**
     * Busca un alumno por su ID
     *
     * @param id ID del alumno.
     * @return El Alumno encontrado, o null si no existe.
     */
    public Alumno obtenerAlumnoPorId(String id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getIdAlumno().equalsIgnoreCase(id)) {
                return alumno;
            }
        }
        return null;
    }

    /**
     * Inscribe a un alumno en un taller, validando que no se pueda inscribir el
     * mismo alumno al mismo taller y parametros, genera un folio unico y fecha
     * actual de cuando se haga la inscripcion.
     *
     * @param alumno El alumno a inscribir.
     * @param taller El taller seleccionado.
     * @return La nueva Inscripcion creada.
     * @throws InscripcionException Si hay errores de validación (ej. duplicado
     * o nulos).
     */
    public Inscripcion inscribirAlumno(Alumno alumno, Taller taller) throws InscripcionException {
        if (alumno == null || taller == null) {
            throw new InscripcionException("Alumno o taller no valido");
        }

        if (yaEstaInscrito(alumno, taller)) {
            throw new InscripcionException("El alumno " + alumno.getNombreCompleto() + " ya esta inscrito en este taller.");
        }

        Inscripcion inscripcion = new Inscripcion("I-" + System.currentTimeMillis(), alumno, taller, LocalDateTime.now());
        inscripciones.add(inscripcion);
        
        notificarObservadores();

        return inscripcion;
    }

    /**
     * Verifica si un alumno ya esta inscrito en un taller especifico.
     *
     * @param alumno El alumno.
     * @param taller El taller.
     * @return true si ya esta inscrito, false si no
     */
    public boolean yaEstaInscrito(Alumno alumno, Taller taller) {
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getAlumno().getIdAlumno().equals(alumno.getIdAlumno())
                    && inscripcion.getTaller().getIdTaller().equals(taller.getIdTaller())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar();
        }
    }

}
