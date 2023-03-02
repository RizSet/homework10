package feature.database.migration;

import org.flywaydb.core.Flyway;

public class DatabaseInitService {
    public void initDb() {
        Flyway flyway = Flyway
                .configure()
                .dataSource("jdbc:h2:./home_work10", null, null)
                .load();

        flyway.migrate();
    }
}
