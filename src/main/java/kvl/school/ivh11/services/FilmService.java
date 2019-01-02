package kvl.school.ivh11.services;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.repositories.abstr.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService
{
    private FilmRepo repo;

    @Autowired
    public FilmService(FilmRepo filmRepo) {
        this.repo = filmRepo;
    }

    public List<Film> getFilms()
    {
        return repo.findAll();
    }

    public Long addFilm(Film film)
    {
        Film save = repo.save(film);
        return save.getId();
    }
}
