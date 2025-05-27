package sistemareserva.service.query.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import sistemareserva.entities.ClientEntity;
import sistemareserva.repository.IClientRepository;

class IClientServiceQuerryImplTest {

    private IClientRepository clientRepository;
    private IClientServiceQuerryImpl service;

    @BeforeEach
    void setUp() {
        clientRepository = mock(IClientRepository.class);
        service = new IClientServiceQuerryImpl(clientRepository);
    }

    @Test
    void deveRetornarClienteQuandoIdExistir() {
        ClientEntity cliente = new ClientEntity();
        cliente.setId(1L);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(cliente));

        ClientEntity resultado = service.findById(1L);

        assertEquals(cliente, resultado);
        verify(clientRepository).findById(1L);
    }

    @Test
    void deveLancarExcecaoQuandoIdNaoExistir() {
        when(clientRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.findById(99L);
        });

        assertTrue(exception.getMessage().contains("Client not found with id: 99"));
        verify(clientRepository).findById(99L);
    }

    @Test
    void deveRetornarTodosClientes() {
        ClientEntity cliente1 = new ClientEntity();
        ClientEntity cliente2 = new ClientEntity();

        List<ClientEntity> lista = Arrays.asList(cliente1, cliente2);

        when(clientRepository.findAll()).thenReturn(lista);

        List<ClientEntity> resultado = service.findAll();

        assertEquals(2, resultado.size());
        verify(clientRepository).findAll();
    }
}