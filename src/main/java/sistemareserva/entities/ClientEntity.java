package sistemareserva.entities;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(
    name = "CLIENTS",
    uniqueConstraints = {
                @UniqueConstraint(name = "UK_PHONE", columnNames = "phone")
    }
    
)

@Getter
@Setter
@ToString

public class ClientEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private long id;
    @jakarta.validation.constraints.Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres")
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, length = 150)
    private String phone;
    @Column(nullable = false, length = 150)
    private String status;
    @Column(nullable = false, length = 150)
    private String observation;
    @Column(nullable = false, length = 150)
    private String numberOfEntities;
    @Column(nullable = false, length = 150)
    private String dayOfReservation;
    @Column(nullable = false, length = 150)
    private String timeOfReservation;



@Override
public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ClientEntity that = (ClientEntity) o;
    return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(phone, that.phone) &&
            Objects.equals(status, that.status) &&
            Objects.equals(observation, that.observation) &&
            Objects.equals(numberOfEntities, that.numberOfEntities);
}

@Override
public int hashCode() {
    return Objects.hash(id, name, phone, status, observation, numberOfEntities);
}

}