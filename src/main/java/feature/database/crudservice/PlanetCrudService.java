package feature.database.crudservice;

import feature.database.entity.Planet;
import feature.database.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PlanetCrudService {
    public void create(Planet planet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public Planet getPlanetById(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public Planet getPlanetByName(String name) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Planet> query = session.createQuery("from Planet where name = :name", Planet.class);
            query.setParameter("name", name);

            return query.stream().findFirst().orElse(null);
        }
    }

    public void update(Planet planet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Planet p set p.name = :name where p.id = :id");
        query.setParameter("name", planet.getName());
        query.setParameter("id", planet.getId());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteByName (String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        long id = getPlanetByName(name).getId();

        Query queryDeleteFromPlanetId = session.createNativeQuery("delete from ticket where from_planet_id = :id");
        queryDeleteFromPlanetId.setParameter("id",id);
        queryDeleteFromPlanetId.executeUpdate();

        Query queryDeleteToPlanetId = session.createNativeQuery("delete from ticket where to_planet_id = :id");
        queryDeleteToPlanetId.setParameter("id",id);
        queryDeleteToPlanetId.executeUpdate();

        Query query = session.createQuery("delete from Planet p where p.name = :name");
        query.setParameter("name", name);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
