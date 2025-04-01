package trio.distribuidos.proyectodistribuidos.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date fecha;
    private int aulasSolicitadas;
    private int laboratoriosSolicitados;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "facultad_id", nullable = false)
    private Facultad facultad;

    @ManyToOne
    @JoinColumn(name = "programaAcademico_id", nullable = false)
    private ProgramaAcademico programaAcademico;

    @OneToOne(mappedBy = "solicitud")
    private Asignacion asignacion;

    public Solicitud() {
    }

    public Solicitud(Date fecha, int aulasSolicitadas, int laboratoriosSolicitados, String estado) {
        this.fecha = fecha;
        this.aulasSolicitadas = aulasSolicitadas;
        this.laboratoriosSolicitados = laboratoriosSolicitados;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAulasSolicitadas() {
        return aulasSolicitadas;
    }

    public void setAulasSolicitadas(int aulasSolicitadas) {
        this.aulasSolicitadas = aulasSolicitadas;
    }

    public int getLaboratoriosSolicitados() {
        return laboratoriosSolicitados;
    }

    public void setLaboratoriosSolicitados(int laboratoriosSolicitados) {
        this.laboratoriosSolicitados = laboratoriosSolicitados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public void setProgramaAcademico(ProgramaAcademico programaAcademico) {
        this.programaAcademico = programaAcademico;
    }
    public ProgramaAcademico getProgramaAcademico() {
        return programaAcademico;
    }
}
