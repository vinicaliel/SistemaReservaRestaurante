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
import sistemareserva.controller.dtoresp.ListClientReservationResponse;
import sistemareserva.controller.dtoresp.SaveClientReservationResponse;
import sistemareserva.controller.dtoresp.UpdateClientReservationResponse;
import sistemareserva.entities.ClientEntity;
import sistemareserva.mapper.IClientMapper;
import sistemareserva.service.IClientService;
import sistemareserva.service.query.IClientServiceQuerry;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;
    private final IClientServiceQuerry service;
    private final IClientMapper mapper;

    @PostMapping
    public SaveClientReservationResponse save(@RequestBody SaveClientReservationRequest request) {

        var entity = mapper.toEntity(request);
        clientService.save(entity);
        return mapper.toResponse(entity);


    }

    @PutMapping("{id}")
    public UpdateClientReservationResponse updateReservation(
    @PathVariable Long id,
    @RequestBody UpdateClientReservationRequest request) {

        var entity = mapper.toEntityUpdate(id, request);
        clientService.update(entity);
        return mapper.toUpdateResponse(entity);


    }

    @GetMapping("{id}")
    public GetClientReservationResponse getClientById(@PathVariable Long id) {
        var entity = service.findById(id);
        return mapper.toGetResponse(entity);
}

@GetMapping
List<ListClientReservationResponse> findAll() {
    var entity = service.findAll();
    return mapper.toListResponse(entity);

    

}

@DeleteMapping("{id}")
public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    clientService.delete(id);
    return ResponseEntity.noContent().build();

}

}

