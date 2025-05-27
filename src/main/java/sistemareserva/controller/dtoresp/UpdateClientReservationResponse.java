package sistemareserva.controller.dtoresp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateClientReservationResponse {
    private Long id;
    private String name;
    private String phone;
    private String status;
    private String observation;
    private String numberOfEntities;
    private String dayOfReservation;
    private String timeOfReservation;
}