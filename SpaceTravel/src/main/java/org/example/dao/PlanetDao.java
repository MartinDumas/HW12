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
            session.saveOrUpdate(planet); // Use saveOrUpdate instead of merge
            tx.commit();
        }
    }

    public Planet getPlanetById(String id) {
        try(Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void getAllPlanets() {
        try(Session session = sessionFactory.openSession()) {
            Query<Planet> query = session.createQuery("FROM Planet", Planet.class);
            List<Planet> list = query.list();
            list.forEach(System.out::println);
        }
    }

    public void update(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            // Fetch the managed instance before updating
            Planet managedPlanet = session.get(Planet.class, planet.getId());
            if (managedPlanet != null) {
                managedPlanet.setId(planet.getId());
                managedPlanet.setName(planet.getName()); // Update properties
            }
            tx.commit();
        }
    }

    public void delete(Planet planet) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            // Fetch the managed instance before deleting
            Planet managedPlanet = session.get(Planet.class, planet.getId());
            if (managedPlanet != null) {
                session.delete(managedPlanet); // Delete the managed entity
            } else {
                System.out.println("Planet not found for deletion.");
            }
            tx.commit();
        }
    }
}
