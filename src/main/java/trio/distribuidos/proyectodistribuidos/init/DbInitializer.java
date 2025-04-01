package trio.distribuidos.proyectodistribuidos.init;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import trio.distribuidos.proyectodistribuidos.models.*;
import trio.distribuidos.proyectodistribuidos.repository.*;

@Component
public class DbInitializer implements CommandLineRunner{
    private Logger log = LoggerFactory.getLogger(getClass());


    @Autowired
    private ProgramaAcademicoRepository programaAcademicoRepository;

    @Autowired
    private FacultadRepository facultadRepository;


    @Override
    public void run(String... args) throws Exception {
        List<String> programas = Arrays.asList(
            // Facultad de Ciencias Sociales
            "Psicología", "Sociología", "Trabajo Social", "Antropología", "Comunicación",
            // Facultad de Ciencias Naturales
            "Biología", "Química", "Física", "Geología", "Ciencias Ambientales",
            // Facultad de Ingeniería
            "Ingeniería Civil", "Ingeniería Electrónica", "Ingeniería de Sistemas", "Ingeniería Mecánica", "Ingeniería Industrial",
            // Facultad de Medicina
            "Medicina General", "Enfermería", "Odontología", "Farmacia", "Terapia Física",
            // Facultad de Derecho
            "Derecho Penal", "Derecho Civil", "Derecho Internacional", "Derecho Laboral", "Derecho Constitucional",
            // Facultad de Artes
            "Bellas Artes", "Música", "Teatro", "Danza", "Diseño Gráfico",
            // Facultad de Educación
            "Educación Primaria", "Educación Secundaria", "Educación Especial", "Psicopedagogía", "Administración Educativa",
            // Facultad de Ciencias Económicas
            "Administración de Empresas", "Contabilidad", "Economía", "Mercadotecnia", "Finanzas",
            // Facultad de Arquitectura
            "Arquitectura", "Urbanismo", "Diseño de Interiores", "Paisajismo", "Restauración de Patrimonio",
            // Facultad de Tecnología
            "Desarrollo de Software", "Redes y Telecomunicaciones", "Ciberseguridad", "Inteligencia Artificial", "Big Data"
        );

        for (String programa : programas) {
            ProgramaAcademico nuevoPrograma = new ProgramaAcademico(programa, "8 Semestres");
            programaAcademicoRepository.save(nuevoPrograma);
        }
        log.info("poniendo facultad");
        facultadRepository.save(new Facultad("asdf"));
    }




}
