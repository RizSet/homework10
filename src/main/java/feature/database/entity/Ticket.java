package feature.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name ="ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    public Ticket (Client client){
        this.client = client;
    }

    public Ticket (Timestamp createdAt,Client client, Planet fromPlanetId, Planet toPlanetId){
        this.createdAt = createdAt;
        this.client = client;
        this.fromPlanetId = fromPlanetId;
        this.toPlanetId = toPlanetId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable=false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable=false)
    private Planet fromPlanetId;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable=false)
    private Planet toPlanetId;
}
