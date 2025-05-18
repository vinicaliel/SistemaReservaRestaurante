package sistemareserva.service.impl;


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
        return clientRepository.save(entity);
    }

    @Override
    public ClientEntity update(final ClientEntity entity){
        var store = clientServiceQuerry.findById(entity.getId());
        store.setName(entity.getName());
        store.setPhone(entity.getPhone());
        store.setTimeOfReservation(entity.getTimeOfReservation());
        store.setObservation(entity.getObservation());
        store.setNumberOfEntities(entity.getNumberOfEntities());
        store.setStatus(entity.getStatus());

        return clientRepository.save(store);

    }
 
    @Override
    public void delete(final long id){
    clientRepository.deleteById(id);
    }


}
