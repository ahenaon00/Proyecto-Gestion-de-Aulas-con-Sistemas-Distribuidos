package trio.distribuidos.proyectodistribuidos.repository;
import org.springframework.stereotype.Repository;
import trio.distribuidos.proyectodistribuidos.models.ProgramaAcademico;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, Long> {
    
}