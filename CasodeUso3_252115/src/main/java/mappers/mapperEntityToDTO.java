/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import models.entitys.Alumno;
import models.entitys.Inscripcion;
import models.entitys.Taller;
import models.dtos.AlumnoDTO;
import models.dtos.InscripcionDTO;
import models.dtos.TallerDTO;

/**
 *
 * @author sonic
 */
public class mapperEntityToDTO {
    
    public TallerDTO toTallerDTO(Taller taller) {
        return new TallerDTO(
            taller.getIdTaller(),
            taller.getNombreTaller(),
            taller.getNombreInstructor(),
            taller.getFecha(),
            taller.getHorario(),
            taller.getDescripcion()
        );
    }

    public AlumnoDTO toAlumnoDTO(Alumno alumno) {
        return new AlumnoDTO(
            alumno.getIdAlumno(),
            alumno.getNombre(),
            alumno.getApellidoPaterno(),
            alumno.getApellidoMaterno(),
            alumno.getSemestre(),
            alumno.getProgramaEducativo()
        );
    }
    
    public InscripcionDTO toInscripcionDTO(Inscripcion inscripcion) {
        AlumnoDTO alumnoDTO = toAlumnoDTO(inscripcion.getAlumno());
        TallerDTO tallerDTO = toTallerDTO(inscripcion.getTaller());
        
        return new InscripcionDTO(
            inscripcion.getFolio(),
            alumnoDTO,
            tallerDTO,
            inscripcion.getFechaInscripcion()
        );
    }
}
