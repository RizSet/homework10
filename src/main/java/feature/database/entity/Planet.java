package feature.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "planet")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    public Planet (String name){
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column
    private String name;
}

