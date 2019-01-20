package kvl.school.ivh11.controller;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.domain.Screen;
import kvl.school.ivh11.domain.Screening;
import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.repository.FilmRepo;
import kvl.school.ivh11.repository.ScreenRepo;
import kvl.school.ivh11.repository.ScreeningRepo;
import kvl.school.ivh11.service.abstr.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces="application/json")
    ResponseEntity<Set<FilmDTO>> getAll()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(filmService.getFilms(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    ResponseEntity<Long> addFilm(@RequestBody FilmDTO filmDTO)
    {
        return new ResponseEntity<>(filmService.addFilm(filmDTO), HttpStatus.OK);
    }
}
