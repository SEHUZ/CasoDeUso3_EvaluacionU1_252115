/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import Observer.Observador;
import excepciones.InscripcionException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import mappers.mapperEntityToDTO;
import models.entitys.Alumno;
import models.GestorDeInscripcion;
import models.entitys.Inscripcion;
import models.entitys.Taller;
import models.dtos.AlumnoDTO;
import models.dtos.InscripcionDTO;
import models.dtos.TallerDTO;
import views.PantallaInscripcionTaller;

/**
 *
 * @author sonic
 *
 * Controlador principal para manejar las operaciones de inscripción en la
 * aplicación.
 */
public class ControlInscripcion implements Observador {

    private GestorDeInscripcion gestor;
    private mapperEntityToDTO mapper;

    private PantallaInscripcionTaller vistaInscripcion;

    public ControlInscripcion(GestorDeInscripcion gestor) {
        this.gestor = gestor;
        this.mapper = new mapperEntityToDTO();
    }

    public void setVistaInscripcion(PantallaInscripcionTaller vista) {
        this.vistaInscripcion = vista;
    }

    public void clearVistaInscripcion() {
        this.vistaInscripcion = null;
    }

    /**
     * Obtiene la lista de talleres disponibles delegando la tarea al modelo sin
     * validaciones
     *
     * @return Lista de Talleres disponibles.
     */
    public List<TallerDTO> obtenerTalleres() {
        return gestor.obtenerTalleresDisponibles()
                .stream()
                .map(mapper::toTallerDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca un alumno por su id validando el input antes de consultar el modelo
     *
     * @param idAlumno id del alumno a buscar
     * @return El alumno encontrado.
     * @throws InscripcionException si el id es invalido o no se encuentra el
     * alumno.
     */
    public AlumnoDTO buscarAlumnoPorId(String idAlumno) throws InscripcionException {
        if (idAlumno == null || idAlumno.isBlank()) {
            throw new InscripcionException("Debe ingresar un ID de alumno.");
        }

        Alumno alumno = gestor.obtenerAlumnoPorId(idAlumno);
        if (alumno == null) {
            throw new InscripcionException("No se encontró un alumno con el ID: " + idAlumno);
        }

        return mapper.toAlumnoDTO(alumno);
    }

    /**
     * Registra una nueva inscripcion
     *
     * @param alumno El alumno a inscribir y encontrado
     * @param taller El taller seleccionado.
     * @return La Inscripcion registrada.
     * @throws InscripcionException
     */
    public InscripcionDTO registrarInscripcion(AlumnoDTO alumnoDTO, TallerDTO tallerDTO) throws InscripcionException {
        Alumno alumno = gestor.obtenerAlumnoPorId(alumnoDTO.getIdAlumno());
        Taller taller = gestor.obtenerTallerPorNombre(tallerDTO.getNombreTaller());

        Inscripcion nuevaInscripcion = gestor.inscribirAlumno(alumno, taller);

        return mapper.toInscripcionDTO(nuevaInscripcion);
    }

    public String generarTicket(InscripcionDTO inscripcion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return "=========== INSTITUTO TECNOLOGICO DE SONORA ===========\n"
                + "\n"
                + "Campus: Itson Nainari\n"
                + "\n"
                + "================= TICKET DE INSCRIPCION =================\n"
                + "Folio: " + inscripcion.getFolio() + "\n"
                + "Alumno: " + inscripcion.getAlumno().getNombre() + " " + inscripcion.getAlumno().getApellidoPaterno() + " " + inscripcion.getAlumno().getApellidoPaterno() + "\n"
                + "Taller: " + inscripcion.getTaller().getNombreTaller() + "\n"
                + "Horario del taller: " + inscripcion.getTaller().getHorario() + "\n"
                + "Fecha inscripción: " + inscripcion.getFechaInscripcion().format(formatter) + "\n"
                + "Instructor del taller: " + inscripcion.getTaller().getNombreInstructor() + "\n"
                + "\n"
                + "=======================================================\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "====================MUCHAS GRACIAS====================\n";
    }

    @Override
    public void actualizar() {
        if (vistaInscripcion != null) {
            JOptionPane.showMessageDialog(vistaInscripcion, "¡Una nueva inscripción ha sido registrada en el sistema!", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
