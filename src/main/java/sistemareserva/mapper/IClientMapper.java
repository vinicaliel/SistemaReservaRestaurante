package sistemareserva.mapper;

import java.util.List;

import sistemareserva.controller.dtoreq.SaveClientReservationRequest;
import sistemareserva.controller.dtoreq.UpdateClientReservationRequest;
import sistemareserva.controller.dtoresp.GetClientReservationResponse;
import sistemareserva.controller.dtoresp.ListClientReservationResponse;
import sistemareserva.controller.dtoresp.SaveClientReservationResponse;
import sistemareserva.controller.dtoresp.UpdateClientReservationResponse;
import sistemareserva.entities.ClientEntity;

public interface IClientMapper {

    ClientEntity toEntity(SaveClientReservationRequest request);
    ClientEntity toEntityUpdate(final Long id, UpdateClientReservationRequest request);
    SaveClientReservationResponse toResponse(ClientEntity entity);
    List<ListClientReservationResponse> toListResponse(List<ClientEntity> entities);
    GetClientReservationResponse toGetResponse(ClientEntity entity);
    UpdateClientReservationResponse toUpdateResponse(ClientEntity entity);
 


}
