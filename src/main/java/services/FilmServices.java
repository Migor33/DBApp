package services;

import entityes.Film;
import entityes.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.FilmRepository;

import java.util.List;

@Service
public class FilmServices {
    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAll() {
        return filmRepository.getAllFilms();
    }

    public Film getFilmSessions(Integer id) {
        return filmRepository.findById(id).get();
    }
}
