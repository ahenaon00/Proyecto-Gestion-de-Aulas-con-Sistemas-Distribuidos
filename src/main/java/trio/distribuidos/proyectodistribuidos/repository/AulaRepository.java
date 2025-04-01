package trio.distribuidos.proyectodistribuidos.repository;
import trio.distribuidos.proyectodistribuidos.models.Aula;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
    
}
