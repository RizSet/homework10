package feature.database.crudservice;

import feature.database.entity.Client;
import feature.database.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ClientCrudService {
    public void create(Client client) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public Client getClientById(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void update(Client client) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(
                "update Client c set c.name = :name where c.id = :id"
        );
        query.setParameter("name", client.getName());
        query.setParameter("id", client.getId());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteByName (String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(
                "delete from Client c where c.name = :name"
        );
        query.setParameter("name", name);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
