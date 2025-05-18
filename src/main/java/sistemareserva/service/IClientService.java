package sistemareserva.service;


import org.springframework.stereotype.Service;

import sistemareserva.entities.ClientEntity;
@Service
public interface IClientService {

    ClientEntity save(final ClientEntity entity);

    ClientEntity update(final ClientEntity entity);

    void delete(final long id);


}
