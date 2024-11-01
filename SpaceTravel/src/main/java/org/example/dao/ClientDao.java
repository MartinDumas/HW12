package org.example.dao;

import org.example.HibernateUtil;
import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDao {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Client client) {

       try(Session session = sessionFactory.openSession()) {
           Transaction tx = session.beginTransaction();
           session.merge(client);
           tx.commit();
       }

    }
    public Client findById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }
    public void findAll() {
        try(Session session = sessionFactory.openSession()) {
           Query query =session.createQuery("from Client", Client.class);
           List<Client> list = query.list();
           list.forEach(System.out::println);

        }
    }

    public void update(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(client);
            tx.commit();
        }
    }

    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            // Fetch the managed entity before deleting
            Client managedClient = session.find(Client.class, client.getId());
            if (managedClient != null) {
                session.delete(managedClient); // Delete the managed entity
            } else {
                System.out.println("Client not found for deletion.");
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
