package sistemareserva.service.query.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sistemareserva.entities.ClientEntity;
import sistemareserva.repository.IClientRepository;
import sistemareserva.service.query.IClientServiceQuerry;

@Service 
@AllArgsConstructor
public class IClientServiceQuerryImpl implements IClientServiceQuerry {

    private final IClientRepository clientRepository;

    @Override
    public ClientEntity findById(Long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Client not found with id: " + id) // You can customize the exception
        );
    }

    @Override
    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    


}
