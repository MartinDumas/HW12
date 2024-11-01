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
           session.persist(client);
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
           Query query =session.createQuery("from Client");
           List<Client> list = query.list();
           list.forEach(System.out::println);

        }
    }

    public void update(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(client);
            tx.commit();
        }
    }

    public void delete(Client client) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(client);
            tx.commit();

        }
    }
}
