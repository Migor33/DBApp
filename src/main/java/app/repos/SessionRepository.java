package app.repos;

import app.entityes.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface SessionRepository extends CrudRepository<Session,Integer> {
    @Query("SELECT s FROM Session s WHERE s.date > date")
    public List<Session> getAllAfterDate(Date date);
}
