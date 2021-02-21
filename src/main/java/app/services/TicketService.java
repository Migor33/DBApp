package app.services;

import app.entityes.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repos.TicketRepository;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getTicketsBySessionId(Integer session_id) {
        return ticketRepository.getTicketBySession(session_id);
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void remove(Ticket t) {
        ticketRepository.delete(t);
    }
}
