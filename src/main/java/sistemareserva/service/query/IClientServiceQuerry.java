package sistemareserva.service.query;

import java.util.List;

import org.springframework.stereotype.Service;

import sistemareserva.entities.ClientEntity;
@Service
public interface IClientServiceQuerry {
    ClientEntity findById(Long id);

    List<ClientEntity> findAll();

}
