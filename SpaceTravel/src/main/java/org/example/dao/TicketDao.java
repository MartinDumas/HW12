package org.example.dao;

import org.example.HibernateUtil;
import org.example.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TicketDao {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void addTicket(Ticket ticket) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(ticket);
            tx.commit();
        }
    }
    public Ticket findTicketById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Ticket ticket =  session.get(Ticket.class, id);
            tx.commit();
            return ticket;
        }
    }
    public void findAllTickets() {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            List<Ticket> tickets =  session.createQuery("from Ticket").list();
            tickets.forEach(System.out::println);
            tx.commit();

        }
    }
    public void deleteTicketById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Ticket ticket =  session.get(Ticket.class, id);
            session.delete(ticket);
            tx.commit();
        }
    }

}
