package sistemareserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sistemareserva.entities.ClientEntity;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {

    
}
