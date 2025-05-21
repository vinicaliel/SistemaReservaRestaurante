package sistemareserva.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sistemareserva.controller.dtoreq.SaveClientReservationRequest;
import sistemareserva.controller.dtoresp.SaveClientReservationResponse;
import sistemareserva.entities.ClientEntity;
import sistemareserva.service.IClientService;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @PostMapping
    public ResponseEntity<SaveClientReservationResponse> saveReservation(@RequestBody SaveClientReservationRequest request) {
        // 🔁 Manualmente transformando DTO → Entidade
        ClientEntity entity = new ClientEntity();
        entity.setName(request.getName());
        entity.setPhone(request.getPhone());
        entity.setStatus(request.getStatus());
        entity.setObservation(request.getObservation());
        entity.setNumberOfEntities(request.getNumberOfEntities());
        entity.setTimeOfReservation(request.getTimeOfReservation());

        // 💾 Salva no banco
        ClientEntity savedClient = clientService.save(entity);

        // 🔁 Manualmente transformando Entidade → DTO de resposta
        SaveClientReservationResponse response = new SaveClientReservationResponse();
        response.setId(savedClient.getId());
        response.setName(savedClient.getName());
        response.setPhone(savedClient.getPhone());
        response.setStatus(savedClient.getStatus());
        response.setObservation(savedClient.getObservation());
        response.setNumberOfEntities(savedClient.getNumberOfEntities());
        response.setTimeOfReservation(savedClient.getTimeOfReservation());

        return ResponseEntity.ok(response);
    }
}
