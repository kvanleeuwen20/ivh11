package kvl.school.ivh11.web.Controller;

import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.service.abstr.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Set;

@Controller
@RequestMapping("/films")
public class MovieController
{
    private FilmService filmService;
    private Locale locale;
    private MessageSource messageSource;

    @Autowired
    public MovieController(FilmService fs)
    {
        this.filmService = fs;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ModelAndView getFilms(@RequestParam(name = "lang") String lang)
    {
        LocalDateTime ld = LocalDateTime.now();
        Set<FilmDTO> films = filmService.getFilmsPlayingToday(ld);

        if(lang.length() > 0)
            this.locale = Locale.forLanguageTag(lang);
        else
            this.locale = Locale.ENGLISH;

        ModelAndView filmVM = new ModelAndView("movies/overview");
        filmVM.addObject("films", films);
        filmVM.addObject("welcomeTxt", messageSource.getMessage("movies.overviewPageTxt", null, locale));

        return filmVM;
    }
}
