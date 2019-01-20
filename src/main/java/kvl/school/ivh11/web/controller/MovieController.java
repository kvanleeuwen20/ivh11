package kvl.school.ivh11.web.controller;

import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.service.abstr.FilmService;
import kvl.school.ivh11.components.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;
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
    public ModelAndView getFilms(Locale locale)
    {
        LocalDateTime ld = LocalDateTime.now();
        Set<FilmDTO> films = filmService.getFilmsPlayingToday(ld);

        NumberFormat numberFormatLocaleCurrency = NumberFormat.getCurrencyInstance(locale);

        films.forEach((f)->{
            f.setPrice(numberFormatLocaleCurrency.format(f.getPrice()));
        });

        ModelAndView filmVM = new ModelAndView("movies/overview");
        filmVM.addObject("films", films);

        return filmVM;
    }
}
