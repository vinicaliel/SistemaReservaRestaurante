package sistemareserva.controller.dtoreq;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateClientReservationRequest {
   
    private String name;
    private String phone;
    private String status;
    private String observation;
    private String numberOfEntities;
    private String timeOfReservation;
}