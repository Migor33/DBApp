package repos;

import entityes.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TicketRepository extends CrudRepository<Ticket,Integer> {

    @Query("SELECT t.* FROM Ticket t WHERE t.session_id = session_Id")
    public  void getTicketBySession(Integer session_id);
}
