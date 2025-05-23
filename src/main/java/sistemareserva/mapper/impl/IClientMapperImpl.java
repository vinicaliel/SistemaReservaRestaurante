package sistemareserva.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import sistemareserva.controller.dtoreq.SaveClientReservationRequest;
import sistemareserva.controller.dtoreq.UpdateClientReservationRequest;
import sistemareserva.controller.dtoresp.GetClientReservationResponse;
import sistemareserva.controller.dtoresp.ListClientReservationResponse;
import sistemareserva.controller.dtoresp.SaveClientReservationResponse;
import sistemareserva.controller.dtoresp.UpdateClientReservationResponse;
import sistemareserva.entities.ClientEntity;
import sistemareserva.mapper.IClientMapper;

@Component
public class IClientMapperImpl implements IClientMapper{
    @Override
    public ClientEntity toEntity (SaveClientReservationRequest request){
        ClientEntity entity = new ClientEntity();
        entity.setName(request.getName());
        entity.setPhone(request.getPhone());
        entity.setStatus(request.getStatus());
        entity.setObservation(request.getObservation());
        entity.setNumberOfEntities(request.getNumberOfEntities());
        entity.setTimeOfReservation(request.getTimeOfReservation());

        return entity;

        

    }
    @Override
    public ClientEntity toEntityUpdate(final Long id, UpdateClientReservationRequest request){
        ClientEntity entity = new ClientEntity();
        entity.setId(id);
        entity.setName(request.getName());
        entity.setPhone(request.getPhone());
        entity.setStatus(request.getStatus());
        entity.setObservation(request.getObservation());
        entity.setNumberOfEntities(request.getNumberOfEntities());
        entity.setTimeOfReservation(request.getTimeOfReservation());

        return entity;

    }
    
    @Override
    public SaveClientReservationResponse toResponse(ClientEntity entity) {
        SaveClientReservationResponse response = new SaveClientReservationResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setPhone(entity.getPhone());
        response.setStatus(entity.getStatus());
        response.setObservation(entity.getObservation());
        response.setNumberOfEntities(entity.getNumberOfEntities());
        response.setTimeOfReservation(entity.getTimeOfReservation());

        return response;
    }

    @Override
    public List<ListClientReservationResponse> toListResponse(List<ClientEntity> entities) {
        List<ListClientReservationResponse> responseList = new ArrayList<>();
        for (ClientEntity entity : entities) {
            ListClientReservationResponse response = new ListClientReservationResponse();
            response.setId(entity.getId());
            response.setName(entity.getName());
            response.setPhone(entity.getPhone());
            response.setStatus(entity.getStatus());
            response.setObservation(entity.getObservation());
            response.setNumberOfEntities(entity.getNumberOfEntities());
            response.setTimeOfReservation(entity.getTimeOfReservation());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public GetClientReservationResponse toGetResponse(ClientEntity entity) {
        GetClientReservationResponse response = new GetClientReservationResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setPhone(entity.getPhone());
        response.setStatus(entity.getStatus());
        response.setObservation(entity.getObservation());
        response.setNumberOfEntities(entity.getNumberOfEntities());
        response.setTimeOfReservation(entity.getTimeOfReservation());

        return response;

    }

    @Override
    public UpdateClientReservationResponse toUpdateResponse(ClientEntity entity){
        UpdateClientReservationResponse response = new UpdateClientReservationResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setPhone(entity.getPhone());
        response.setStatus(entity.getStatus());
        response.setObservation(entity.getObservation());
        response.setNumberOfEntities(entity.getNumberOfEntities());
        response.setTimeOfReservation(entity.getTimeOfReservation());

        return response;
    } 

}


