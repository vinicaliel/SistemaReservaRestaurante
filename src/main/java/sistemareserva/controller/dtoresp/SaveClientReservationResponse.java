// SaveClientReservationResponse.java
package sistemareserva.controller.dtoresp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveClientReservationResponse {
    private long id;
    private String name;
    private String phone;
    private String status;
    private String observation;
    private String numberOfEntities;
    private String timeOfReservation;
}
