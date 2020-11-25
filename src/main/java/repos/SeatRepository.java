package repos;


import entityes.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SeatRepository extends CrudRepository<Seat,Integer> {
}
