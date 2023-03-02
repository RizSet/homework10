import feature.database.entity.client.Client;
import feature.database.entity.client.ClientCrudService;
import feature.database.entity.planet.Planet;
import feature.database.entity.planet.PlanetCrudService;
import feature.database.hibernate.HibernateUtil;
import feature.database.migration.DatabaseInitService;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        new DatabaseInitService().initDb();
        System.out.println(new ClientCrudService().getClientById(6));
        new ClientCrudService().update(new Client(6,"qad"));
        System.out.println(new ClientCrudService().getClientById(6));
        new ClientCrudService().deleteByName("qad");
        System.out.println(new ClientCrudService().getClientById(6));

        new DatabaseInitService().initDb();
        System.out.println(new PlanetCrudService().getPlanetById(1));
        new PlanetCrudService().update(new Planet(1,"qad"));
        System.out.println(new PlanetCrudService().getPlanetById(1));
        new PlanetCrudService().deleteByName("qad");
        System.out.println(new PlanetCrudService().getPlanetById(1));
    }
}