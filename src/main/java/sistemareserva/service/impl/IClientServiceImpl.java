package sistemareserva.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sistemareserva.entities.ClientEntity;
import sistemareserva.repository.IClientRepository;
import sistemareserva.service.IClientService;
import sistemareserva.service.query.IClientServiceQuerry;

@Service
@AllArgsConstructor

public class IClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;
    private final IClientServiceQuerry clientServiceQuerry;

    @Override
    public ClientEntity save(final ClientEntity entity) {
        return null;
    }

        @Override
    public ClientEntity update(final ClientEntity entity){
        return null;
    }
 
    @Override
    public void delete(final long id){
    return null;
    }


}
