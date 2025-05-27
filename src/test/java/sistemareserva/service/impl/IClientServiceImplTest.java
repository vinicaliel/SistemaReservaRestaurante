package sistemareserva.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import sistemareserva.entities.ClientEntity;
import sistemareserva.repository.IClientRepository;
import sistemareserva.service.query.IClientServiceQuerry;

class IClientServiceImplTest {

    private IClientRepository clientRepository;
    private IClientServiceQuerry clientServiceQuerry;
    private IClientServiceImpl service;

    @BeforeEach
    void setUp() {
        clientRepository = mock(IClientRepository.class);
        clientServiceQuerry = mock(IClientServiceQuerry.class);
        service = new IClientServiceImpl(clientRepository, clientServiceQuerry);
    }

    @Test
    void deveSalvarClienteComSucesso() {
        ClientEntity entity = new ClientEntity();
        when(clientRepository.save(entity)).thenReturn(entity);

        ClientEntity resultado = service.save(entity);

        assertEquals(entity, resultado);
        verify(clientRepository).save(entity);
    }

    @Test
    void deveAtualizarClienteComSucesso() {
        // Simula uma entidade existente no banco
        ClientEntity existente = new ClientEntity();
        existente.setId(1L);
        existente.setName("Antigo Nome");

        // Simula nova entidade com dados atualizados
        ClientEntity atualizado = new ClientEntity();
        atualizado.setId(1L);
        atualizado.setName("Novo Nome");
        atualizado.setPhone("123456789");
        atualizado.setObservation("Mesa perto da janela");
        atualizado.setNumberOfEntities("2");
        atualizado.setStatus("CONFIRMADO");

        when(clientServiceQuerry.findById(1L)).thenReturn(existente);
        when(clientRepository.save(existente)).thenReturn(existente);

        ClientEntity resultado = service.update(atualizado);

        assertEquals("Novo Nome", resultado.getName());
        assertEquals("123456789", resultado.getPhone());
        verify(clientRepository).save(existente);
    }

    @Test
    void deveDeletarClientePorId() {
        long id = 1L;

        service.delete(id);

        verify(clientRepository).deleteById(id);
    }
}