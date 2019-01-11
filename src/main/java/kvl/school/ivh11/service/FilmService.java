package kvl.school.ivh11.service;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.repository.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FilmService
{
    private final FilmRepo repo;

    @Autowired
    public FilmService(FilmRepo filmRepo) {
        this.repo = filmRepo;
    }

    public Set<Film> getFilms()
    {
        return new HashSet<>(repo.findAll());
    }

    public Long addFilm(Film film)
    {
        Film save = repo.save(film);
        return save.getId();
    }
}
