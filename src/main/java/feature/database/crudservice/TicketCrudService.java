//package feature.database.crudservice;
//
//import feature.database.entity.Client;
//import feature.database.entity.Planet;
//import feature.database.entity.Ticket;
//import feature.database.hibernate.HibernateUtil;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
//public class TicketCrudService {
//
//    public void create(Ticket ticket) {
//        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        long fromPlanetId = ticket.getFromPlanetId().getId();
//        long toPlanetId = ticket.getToPlanetId().getId();
//        long clientId = ticket.getClient().getId();
////        if (fromPlanetId = )
//        session.persist(ticket);
//        transaction.commit();
//        session.close();
//    }
//
//    public Client getClientById(long id) {
//        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
//            return session.get(Client.class, id);
//        }
//    }
//
//    public void update(Client client) {
//        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery(
//                "update Client c set c.name = :name where c.id = :id"
//        );
//        query.setParameter("name", client.getName());
//        query.setParameter("id", client.getId());
//        query.executeUpdate();
//        transaction.commit();
//        session.close();
//    }
//
//    public void deleteByName (String name) {
//        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.createQuery(
//                "delete from Client c where c.name = :name"
//        );
//        query.setParameter("name", name);
//        query.executeUpdate();
//        transaction.commit();
//        session.close();
//    }
//}
