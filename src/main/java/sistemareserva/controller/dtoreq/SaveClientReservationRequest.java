package sistemareserva.controller.dtoreq;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveClientReservationRequest {
    private String name;
    private String phone;
    private String status;
    private String observation;
    private String numberOfEntities;
    private String dayOfReservation;
    private String timeOfReservation;
}