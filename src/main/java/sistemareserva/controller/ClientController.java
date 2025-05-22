package sistemareserva.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sistemareserva.controller.dtoreq.SaveClientReservationRequest;
import sistemareserva.controller.dtoreq.UpdateClientReservationRequest;
import sistemareserva.controller.dtoresp.GetClientReservationResponse;
import sistemareserva.controller.dtoresp.SaveClientReservationResponse;
import sistemareserva.controller.dtoresp.UpdateClientReservationResponse;
import sistemareserva.entities.ClientEntity;
import sistemareserva.service.IClientService;
import sistemareserva.service.query.IClientServiceQuerry;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;
    private final IClientServiceQuerry service;

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

    @PutMapping("{id}")
    public ResponseEntity<UpdateClientReservationResponse> updateReservation(
    @PathVariable Long id,
    @RequestBody UpdateClientReservationRequest request) {
        
        
        // 🔁 Manualmente transformando DTO → Entidade
        ClientEntity entity = new ClientEntity();
        entity.setId(id);
        entity.setName(request.getName());
        entity.setPhone(request.getPhone());
        entity.setStatus(request.getStatus());
        entity.setObservation(request.getObservation());
        entity.setNumberOfEntities(request.getNumberOfEntities());
        entity.setTimeOfReservation(request.getTimeOfReservation());

        // 💾 Atualiza no banco
        ClientEntity updatedClient = clientService.update(entity);

        // 🔁 Manualmente transformando Entidade → DTO de resposta
        UpdateClientReservationResponse response = new UpdateClientReservationResponse();
        response.setId(updatedClient.getId());
        response.setName(updatedClient.getName());
        response.setPhone(updatedClient.getPhone());
        response.setStatus(updatedClient.getStatus());
        response.setObservation(updatedClient.getObservation());
        response.setNumberOfEntities(updatedClient.getNumberOfEntities());
        response.setTimeOfReservation(updatedClient.getTimeOfReservation());

        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<GetClientReservationResponse> getClientById(@PathVariable Long id) {
        ClientEntity client = service.findById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        GetClientReservationResponse response = new GetClientReservationResponse();
        response.setId(client.getId());
        response.setName(client.getName());
        response.setPhone(client.getPhone());
        response.setStatus(client.getStatus());
        response.setObservation(client.getObservation());
        response.setNumberOfEntities(client.getNumberOfEntities());
        response.setTimeOfReservation(client.getTimeOfReservation());

        return ResponseEntity.ok(response);

    

}

@GetMapping
public ResponseEntity<List<GetClientReservationResponse>> getAllClients() {
    List<ClientEntity> clients = service.findAll();
    List<GetClientReservationResponse> responseList = new ArrayList<>();

    for (ClientEntity client : clients) {
        GetClientReservationResponse response = new GetClientReservationResponse();
        response.setId(client.getId());
        response.setName(client.getName());
        response.setPhone(client.getPhone());
        response.setStatus(client.getStatus());
        response.setObservation(client.getObservation());
        response.setNumberOfEntities(client.getNumberOfEntities());
        response.setTimeOfReservation(client.getTimeOfReservation());

        responseList.add(response);
    }

    return ResponseEntity.ok(responseList);
}

@DeleteMapping("{id}")
public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    clientService.delete(id);
    return ResponseEntity.noContent().build();

}

}

