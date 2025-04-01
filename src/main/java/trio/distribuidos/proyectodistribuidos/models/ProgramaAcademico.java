package trio.distribuidos.proyectodistribuidos.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ProgramaAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String semestre;

    @ManyToOne
    @JoinColumn(name = "facultad_id", nullable = false)
    private Facultad facultad;

    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
    private List<Solicitud> solicitud =  new ArrayList<>();

    public ProgramaAcademico() {
    }

    public ProgramaAcademico(String nombre, String semestre) {
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public List<Solicitud> getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(List<Solicitud> solicitud) {
        this.solicitud = solicitud;
    }
}
