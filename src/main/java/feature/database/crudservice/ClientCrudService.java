package feature.database.crudservice;

import feature.database.entity.Client;
import feature.database.dao.DAOClient;
import feature.database.dao.DAOTicket;
import feature.database.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Set;

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

    public boolean getClientChecking(Client client) {
        if (client == null) return false;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Query<Client> query = session.createQuery("from Client where name = :name and id = :id", Client.class);
            query.setParameter("name", client.getName());
            query.setParameter("id", client.getId());
            if (query.stream().findFirst().orElse(null) == null){
                return false;
            } else if (query.stream().findFirst().orElse(null) != null) {
                return true;
            }
            return false;
        }
    }

    public DAOClient getClientByIdWithSetTicket(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            Client client = session.get(Client.class, id);
            Set<DAOTicket> setTicketByClientID = new TicketCrudService().getSetTicketByClientID(client.getId());
            return new DAOClient(client.getId(), client.getName(), setTicketByClientID);
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

    public void deleteById (long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(getClientById(id));
        transaction.commit();
        session.close();
    }


}
