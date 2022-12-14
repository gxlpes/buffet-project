package repository;

import entity.Client;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientRepository {

    public static SessionFactory sessionFactory;

    public static void setup() {
        Configuration config = new Configuration();

        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.1.1:3306/buffet_atos");
        config.setProperty("hibernate.connection.username", "root");
        config.setProperty("hibernate.connection.password", "");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        config.addAnnotatedClass(Client.class);
        sessionFactory = config.buildSessionFactory();
    }

    public void close() {
        sessionFactory.close();
    }

    public String salvar(Client clientData) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Client client = new Client();
        client.setId(clientData.getId());
        client.setClient(clientData.getClient());
        client.setGuests(clientData.getGuests());
        client.setDesert(clientData.getDesert());
        client.setWaiters(clientData.getWaiters());
        client.setPriceGuest(clientData.getPriceGuest());
        client.setPriceGuests(clientData.getPriceGuests());
        client.setPriceWaiters(clientData.getPriceWaiters());
        client.setPriceTotal(clientData.getPriceTotal());

        session.save(client);
        tx.commit();
        session.close();

        return "/clientData.xhtml?faces-redirect=true";
    }

    public static List<Client> getAll() {
        setup();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Client> listClients = session.createQuery("from Client", Client.class).getResultList();
        session.getTransaction().commit();
        session.close();

        return listClients;
    }

    public static int totalClients() {
        setup();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Client> listClients = session.createQuery("from Client", Client.class).getResultList();
        session.getTransaction().commit();
        session.close();

        int qtd = listClients.size();

        return qtd;
    }

    public static Client getClient(String id) {
        setup();
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Query query = session.createQuery(" from Client where id_client=:id", Client.class);
        query.setParameter("id", id);

        Client client = (Client) query.getSingleResult();

        transaction.commit();
        session.close();

        return client;
    }

    public static String deletar(String id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Client client = session.find(Client.class, id);
        session.delete(client);
        session.getTransaction().commit();
        session.close();
        return "/pages/consulta.xhtml?faces-redirect=true";

    }

}




