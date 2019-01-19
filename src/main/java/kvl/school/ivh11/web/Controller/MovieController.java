package kvl.school.ivh11.web.Controller;

import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.service.abstr.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Controller
@RequestMapping("/films")
public class MovieController
{
    private FilmService filmService;

    @Autowired
    public MovieController(FilmService fs)
    {
        this.filmService = fs;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ModelAndView getFilms()
    {
        LocalDateTime ld = LocalDateTime.now();
        Set<FilmDTO> screenings = filmService.getFilmsPlayingToday(ld.format(DateTimeFormatter.ofPattern("yy-mm-dd")));

        ModelAndView filmVM = new ModelAndView("movies/overview");
        filmVM.addObject("screening", screenings);

        return filmVM;
    }
}
