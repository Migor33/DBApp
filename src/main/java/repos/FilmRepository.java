package repos;

import entityes.Film;
import entityes.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface FilmRepository extends CrudRepository<Film,Integer> {

    @Query("SELECT f from Film f")
    public List<Film> getAllFilms();

}
