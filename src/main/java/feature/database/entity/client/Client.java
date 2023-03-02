package feature.database.entity.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.awt.event.ActionListener;

@Table(name = "client")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    public Client (String name){
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column
    private String name;
}
