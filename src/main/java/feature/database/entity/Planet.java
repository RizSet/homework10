package feature.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Table(name = "planet")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    public Planet (String name){
        this.name = name;
    }
    public Planet (long id, String name){
        this.id = id;
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "fromPlanetId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Ticket> ticketFrom;

    @OneToMany(mappedBy = "toPlanetId",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Ticket> ticketsTo;
}

