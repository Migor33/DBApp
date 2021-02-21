package app.services;

import app.entityes.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import app.repos.FilmRepository;

import java.util.List;

@Service
@Configurable
public class FilmServices {
    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAll() {
        return filmRepository.getAllFilms();
    }

    public Film getFilm(Integer id) {
        return filmRepository.findById(id).get();
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public void remove(Film t) {
        filmRepository.delete(t);
    }
}
