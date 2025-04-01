package trio.distribuidos.proyectodistribuidos.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany
    private List<ProgramaAcademico> programaAcademico;

    @OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL)
    private List<Solicitud> solicitud =  new ArrayList<>();

    public Facultad (){}

    public Facultad (String nombre){
        this.nombre = nombre;
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

    public List<ProgramaAcademico> getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(List<ProgramaAcademico> programaAcademico) {
        this.programaAcademico = programaAcademico;
    }
}