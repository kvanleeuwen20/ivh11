package kvl.school.ivh11.controllers;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class ApiMovieController
{
    private final FilmService filmService;

    @Autowired
    public ApiMovieController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/")
    List<Film> all()
    {
       return filmService.getFilms();
    }

    @PostMapping("/")
    Long newMovie(@RequestBody FilmDTO filmDTO)
    {
        Film film = filmDTO.toFilm();
        return filmService.addFilm(film);
    }
}
