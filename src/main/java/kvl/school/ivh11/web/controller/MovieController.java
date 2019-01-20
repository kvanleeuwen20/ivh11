package kvl.school.ivh11.web.controller;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.dto.FilmDTO;
import kvl.school.ivh11.service.abstr.FilmService;
import kvl.school.ivh11.components.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;

@Controller
@RequestMapping("/films")
public class MovieController implements WebMvcConfigurer
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
            f.setPrice(numberFormatLocaleCurrency.format(Double.parseDouble(f.getPrice())));
        });

        ModelAndView filmVM = new ModelAndView("movies/overview");
        filmVM.addObject("films", films);

        return filmVM;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('Employee')")
    public String addForm(Model model)
    {
        model.addAttribute("filmDto", new FilmDTO());
        return "movies/add";
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('Employee')")
    public String checkPersonInfo(@Valid FilmDTO filmDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "movies/add";
        }else{
            filmService.addFilm(filmDto);

            return "redirect:/films/all";
        }
    }
}
