package feature.database.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class DAOTicket {
    private long id;
    private Timestamp createdAt;
    private DAOClient client;
    private DAOPlanet fromPlanetId;
    private DAOPlanet toPlanetId;
}
