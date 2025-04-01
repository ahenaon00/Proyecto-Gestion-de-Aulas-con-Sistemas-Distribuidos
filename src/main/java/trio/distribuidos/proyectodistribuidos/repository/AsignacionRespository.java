package trio.distribuidos.proyectodistribuidos.repository;
import trio.distribuidos.proyectodistribuidos.models.Asignacion;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AsignacionRespository extends JpaRepository<Asignacion, Long> {
    
}
