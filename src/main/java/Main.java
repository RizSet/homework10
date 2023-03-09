import feature.database.entity.Client;
import feature.database.crudservice.ClientCrudService;
import feature.database.entity.Planet;
import feature.database.crudservice.PlanetCrudService;
import feature.database.migration.DatabaseInitService;

public class Main {
    public static void main(String[] args) {

        new DatabaseInitService().initDb();
        System.out.println(new ClientCrudService().getClientById(6));
        new ClientCrudService().update(new Client(6, "qad"));
        System.out.println(new ClientCrudService().getClientById(6));
        new ClientCrudService().deleteByName("qad");
        System.out.println(new ClientCrudService().getClientById(6));

        System.out.println(new PlanetCrudService().getPlanetById(1));
        new PlanetCrudService().update(new Planet(1, "qad"));
        System.out.println(new PlanetCrudService().getPlanetById(1));
        new PlanetCrudService().deleteByName("qad");
        System.out.println(new PlanetCrudService().getPlanetById(1));
    }
}