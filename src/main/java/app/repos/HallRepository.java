package app.repos;

import app.entityes.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HallRepository extends CrudRepository<Hall,Integer> {
}
