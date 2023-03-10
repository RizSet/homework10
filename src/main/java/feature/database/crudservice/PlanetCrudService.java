package feature.database.crudservice;

import feature.database.entity.Client;
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

    public boolean getPlanetChecking(Planet planet) {
        if (planet == null) return false;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Planet> query = session.createQuery("from Planet where name = :name and id = :id", Planet.class);
            query.setParameter("name", planet.getName());
            query.setParameter("id", planet.getId());
            if (query.stream().findFirst().orElse(null) == null){
                return false;
            } else if (query.stream().findFirst().orElse(null) != null) {
                return true;
            }
            return false;
        }
    }

    public void deleteByName (String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(getPlanetByName(name));
        transaction.commit();
        session.close();
    }
}
