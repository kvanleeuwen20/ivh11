package kvl.school.ivh11.controllers;

import kvl.school.ivh11.domain.ApiUser;
import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.repositories.abstr.ApiUserRepo;
import kvl.school.ivh11.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class ApiMovieController
{
    private final ApiUserRepo idpUser;
    private final FilmService filmService;

    @Autowired
    public ApiMovieController(FilmService filmService, ApiUserRepo idpUser)
    {
        this.filmService = filmService;
        this.idpUser = idpUser;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, consumes="application/json", produces="application/json")
    ResponseEntity<List<Film>> all()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(filmService.getFilms(), headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    ResponseEntity<Long> newMovie(@RequestBody FilmDTO filmDTO)
    {
        Film film = filmDTO.toFilm();
        return new ResponseEntity<>(filmService.addFilm(film), HttpStatus.OK);
    }

    private boolean isAllowIP(List<String> allowedIps, String remoteAddr)
    {
        for (String allowedIp : allowedIps)
        {
            return true;
        }
        return false;
    }
}
