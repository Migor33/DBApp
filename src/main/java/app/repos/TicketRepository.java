package app.repos;

import app.entityes.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TicketRepository extends CrudRepository<Ticket,Integer> {

    @Query("SELECT t FROM Ticket t WHERE t.session.session_Id = session_id")
    public List<Ticket> getTicketBySession(Integer session_id);
}
