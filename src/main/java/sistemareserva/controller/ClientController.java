package sistemareserva.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sistemareserva.entities.ClientEntity;
import sistemareserva.service.IClientService;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;

    @PostMapping
    public ResponseEntity<ClientEntity> saveReservation(@RequestBody ClientEntity client) {
        ClientEntity savedClient = clientService.save(client);
        return ResponseEntity.ok(savedClient);
    }
}