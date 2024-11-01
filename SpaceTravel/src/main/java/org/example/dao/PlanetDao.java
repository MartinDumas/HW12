package org.example.dao;

import org.example.HibernateUtil;
import org.example.entity.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlanetDao {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(planet);
            tx.commit();
        }
    }
    public Planet getPlanetById(int id) {
        try(Session session = sessionFactory.openSession()) {
           return session.get(Planet.class, id);
        }
    }
    public void getAllPlanets() {
        try(Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Planet ");
            List<Planet> list = query.list();
            list.forEach(System.out::println);


        }
    }
    public void update(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(planet);
            tx.commit();
        }
    }
    public void delete(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(planet);
            tx.commit();
        }
    }
}
