package kvl.school.ivh11.controller;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/movies")
public class FilmController
{
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService)
    {
        this.filmService = filmService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces="application/json")
    ResponseEntity<Set<FilmDTO>> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(filmService.getFilms(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    ResponseEntity<Long> addFilm(@RequestBody FilmDTO filmDTO)
    {
        return new ResponseEntity<>(filmService.addFilm(filmDTO), HttpStatus.OK);
    }
}
