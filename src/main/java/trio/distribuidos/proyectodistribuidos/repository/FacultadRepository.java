package trio.distribuidos.proyectodistribuidos.repository;
import trio.distribuidos.proyectodistribuidos.models.Facultad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultadRepository extends JpaRepository<Facultad, Long>{
    
}
