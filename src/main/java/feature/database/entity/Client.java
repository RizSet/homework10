package feature.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.awt.event.ActionListener;
import java.util.Set;

@Table(name = "client")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    public Client (String name){
        this.name = name;
    }
    public Client (long id, String name){
        this.id = id;
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "client")
    private Set<Ticket> tickets;
}
