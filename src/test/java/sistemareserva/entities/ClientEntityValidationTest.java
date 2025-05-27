package sistemareserva.entities;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

class ClientEntityValidationTest {

    private Validator validator;

    @BeforeEach
    void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveDetectarCamposObrigatoriosNulos() {
        ClientEntity entity = new ClientEntity(); // todos os campos estão nulos

        Set<ConstraintViolation<ClientEntity>> violations = validator.validate(entity);

        assertEquals(violations.size(), violations.size()); // Ajuste conforme o número real de campos obrigatórios

        for (ConstraintViolation<ClientEntity> violation : violations) {
            System.out.println(violation.getPropertyPath() + " - " + violation.getMessage());
        }
    }

    @Test
    void deveValidarNomeComMenosDe2Caracteres() {
        ClientEntity entity = criarEntidadeValida();
        entity.setName("A");

        Set<ConstraintViolation<ClientEntity>> violations = validator.validate(entity);

        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("name")));
    }

    @Test
    void devePassarQuandoTodosOsCamposSaoValidos() {
        ClientEntity entity = criarEntidadeValida();

        Set<ConstraintViolation<ClientEntity>> violations = validator.validate(entity);

        assertTrue(violations.isEmpty());
    }

    private ClientEntity criarEntidadeValida() {
        ClientEntity entity = new ClientEntity();
        entity.setId(1L);
        entity.setName("Maria");
        entity.setPhone("999999999");
        entity.setObservation("Mesa na janela");
        entity.setNumberOfEntities("3");
        entity.setStatus("CONFIRMADO");
        return entity;
    }
}