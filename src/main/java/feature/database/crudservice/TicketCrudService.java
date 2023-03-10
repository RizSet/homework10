package feature.database.crudservice;

import feature.database.dao.DAOClient;
import feature.database.dao.DAOPlanet;
import feature.database.dao.DAOTicket;
import feature.database.entity.*;
import feature.database.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TicketCrudService {

    public void create(Ticket ticket) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        if (checking(ticket)) {
            session.persist(ticket);
        }else {
            System.out.println("Invalid Data");
        }
        transaction.commit();
        session.close();
    }

    public Ticket getTicketById(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public Ticket getTicketByIdClient(long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void update(Ticket ticket) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(ticket);
        transaction.commit();
        session.close();
    }

    public void deleteById(long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(getTicketById(id));
        transaction.commit();
        session.close();
    }

    private boolean checking(Ticket ticket) {
        Client client = ticket.getClient();
        Planet fromPlanetId = ticket.getFromPlanetId();
        Planet toPlanetId = ticket.getToPlanetId();

        boolean clientChecking = new ClientCrudService().getClientChecking(client);
        boolean planetChecking = new PlanetCrudService().getPlanetChecking(fromPlanetId);
        boolean planetChecking1 = new PlanetCrudService().getPlanetChecking(toPlanetId);
        if (clientChecking && planetChecking && planetChecking1) return true;
        return false;
    }

    public Set<DAOTicket> getSetTicketByClientID(long in) {
        long id;
        Timestamp createdAt;
        DAOClient client;
        DAOPlanet fromPlanetId;
        DAOPlanet toPlanetId;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            List<Ticket> ticketSet = session.createQuery("from Ticket WHERE client = " + in, Ticket.class).list();
            Set<DAOTicket> daoTicketSet = new HashSet<>();
            for (Ticket t : ticketSet) {
                id = t.getId();
                createdAt = t.getCreatedAt();
                client = new DAOClient(t.getClient().getId(), t.getClient().getName());
                fromPlanetId = new DAOPlanet(t.getFromPlanetId().getId(), t.getFromPlanetId().getName());
                toPlanetId = new DAOPlanet(t.getToPlanetId().getId(), t.getToPlanetId().getName());
                daoTicketSet.add(new DAOTicket(id, createdAt, client, fromPlanetId, toPlanetId));
            }
            return daoTicketSet;
        }
    }
}
