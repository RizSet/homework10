package feature.database.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DAOClient {
    private long id;
    private String name;
    private Set<DAOTicket> tickets;

    public DAOClient(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
