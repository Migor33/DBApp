package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
}
