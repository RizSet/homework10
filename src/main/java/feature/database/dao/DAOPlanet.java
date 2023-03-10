package feature.database.dao;

import feature.database.entity.Ticket;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DAOPlanet {
    private long id;
    private String name;
    private Set<Ticket> ticketFrom;
    private Set<Ticket> ticketsTo;

    public DAOPlanet(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
