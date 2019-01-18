package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.repository.FilmRepo;
import kvl.school.ivh11.service.abstr.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("filmService")
public class FilmServiceImpl implements FilmService
{
    @Autowired
    private FilmRepo repo;

    public FilmServiceImpl(FilmRepo filmRepo)
    {
        this.repo = filmRepo;
    }

    private Set<FilmDTO> convertToFilmDTOSet(Set<Film> films)
    {
        return films.stream().map(FilmDTO::new).collect(Collectors.toSet());
    }

    public Set<FilmDTO> getFilms()
    {
        Set<Film> films = new HashSet<>(repo.findAll());
        return convertToFilmDTOSet(films);
    }

    public Set<FilmDTO> getFilmsPlayingToday(String date)
    {
        Set<Film> films = new HashSet<>(repo.getFilmsPlayingToday(date));
        return convertToFilmDTOSet(films);
    }

    public Long addFilm(FilmDTO filmDto)
    {
        Film f = new Film();
        f = filmDto.toFilm();

        Film save = repo.save(f);
        return save.getId();
    }
}
