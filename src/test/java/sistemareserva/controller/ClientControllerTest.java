package sistemareserva.controller;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

class ClientControllerTest {

    private IClientService clientService;
    private IClientServiceQuerry serviceQuerry;
    private IClientMapper mapper;
    private ClientController controller;

    @BeforeEach
    void setUp() {
        clientService = mock(IClientService.class);
        serviceQuerry = mock(IClientServiceQuerry.class);
        mapper = mock(IClientMapper.class);
        controller = new ClientController(clientService, serviceQuerry, mapper);
    }

       @Test
    void deveSalvarReservaComSucesso() {
        var request = new SaveClientReservationRequest();
        var entity = new ClientEntity();
        var response = new SaveClientReservationResponse();

        when(mapper.toEntity(request)).thenReturn(entity);
        when(clientService.save(entity)).thenReturn(entity); // Corrigido aqui
        when(mapper.toResponse(entity)).thenReturn(response);

        var resultado = controller.save(request);

        assertEquals(response, resultado);
        verify(clientService).save(entity);
    }

    @Test
    void deveAtualizarReservaComSucesso() {
        Long id = 1L;
        var request = new UpdateClientReservationRequest();
        var entity = new ClientEntity();
        var response = new UpdateClientReservationResponse();

        when(mapper.toEntityUpdate(id, request)).thenReturn(entity);
        when(clientService.update(entity)).thenReturn(entity); // Corrigido aqui
        when(mapper.toUpdateResponse(entity)).thenReturn(response);

        var resultado = controller.updateReservation(id, request);

        assertEquals(response, resultado);
        verify(clientService).update(entity);
    }

    @Test
    void deveBuscarReservaPorIdComSucesso() {
        Long id = 1L;
        var entity = new ClientEntity();
        var response = new GetClientReservationResponse();

        when(serviceQuerry.findById(id)).thenReturn(entity);
        when(mapper.toGetResponse(entity)).thenReturn(response);

        var resultado = controller.getClientById(id);

        assertEquals(response, resultado);
    }

    @Test
    void deveRetornarListaDeReservas() {
        var listaEntidades = List.of(new ClientEntity(), new ClientEntity());
        var listaResposta = List.of(new ListClientReservationResponse(), new ListClientReservationResponse());

        when(serviceQuerry.findAll()).thenReturn(listaEntidades);
        when(mapper.toListResponse(listaEntidades)).thenReturn(listaResposta);

        var resultado = controller.findAll();

        assertEquals(listaResposta.size(), resultado.size());
    }

    @Test
    void deveExcluirReservaComSucesso() {
        Long id = 1L;

        doNothing().when(clientService).delete(id);

        var resposta = controller.deleteClient(id);

        assertEquals(204, resposta.getStatusCodeValue());
        verify(clientService).delete(id);
    }
}