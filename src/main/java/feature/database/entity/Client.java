package feature.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Ticket> tickets;
}
