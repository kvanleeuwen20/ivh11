package kvl.school.ivh11.controller;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.domain.Screen;
import kvl.school.ivh11.domain.Screening;
import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.repository.FilmRepo;
import kvl.school.ivh11.repository.ScreenRepo;
import kvl.school.ivh11.repository.ScreeningRepo;
import kvl.school.ivh11.service.FilmService;
import kvl.school.ivh11.dto.FilmDTO;
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
    @Autowired
    private FilmRepo repo;

    @Autowired
    private ScreenRepo sRepo;

    @Autowired
    private ScreeningRepo screeningRepo;

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

        Film film = repo.getOne(1l);

        Screen screen = sRepo.getOne(1l);
        LocalDateTime startTime = LocalDateTime.of(2019, 01, 30, 16, 30, 12);
        LocalDateTime endTime = LocalDateTime.of(2019, 01, 30, 18, 50, 12);

        Screening s = new Screening(startTime, endTime, film, screen);

        screeningRepo.save(s);
        screeningRepo.flush();

        System.out.println("OUWEHOER");

        return new ResponseEntity<>(filmService.getFilms(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    ResponseEntity<Long> addFilm(@RequestBody FilmDTO filmDTO)
    {
        return new ResponseEntity<>(filmService.addFilm(filmDTO), HttpStatus.OK);
    }
}
