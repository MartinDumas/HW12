package org.example.crudservice;

import org.example.dao.TicketDao;
import org.example.entity.Ticket;

import java.util.List;

public class TicketCrudService {
    private TicketDao ticketDao = new TicketDao();

    public void add(Ticket ticket) {
        ticketDao.addTicket(ticket);
    }
    public Ticket findById(Long id) {
       return ticketDao.findTicketById(id);
    }
    public void findAll() {
        ticketDao.findAllTickets();
    }
    public void delete(Ticket ticket) {
        ticketDao.deleteTicketById(ticket.getId());
    }
}
