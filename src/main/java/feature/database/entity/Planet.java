package feature.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @ToString.Exclude
    @OneToMany(mappedBy = "fromPlanetId")
    private Set<Ticket> ticketFrom;

    @ToString.Exclude
    @OneToMany(mappedBy = "toPlanetId")
    private Set<Ticket> ticketsTo;
}

