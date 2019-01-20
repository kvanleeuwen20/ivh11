package kvl.school.ivh11.dto;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.domain.Screening;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Getter
@Setter
public class FilmDTO implements Serializable {
    private String title;
    private int duration;
    private String description;
    private String price;

    private Set<ScreeningDTOForFilm> screenings;

    public FilmDTO(Film film)
    {
        this.title = film.getTitle();
        this.duration = film.getDuration();
        this.description = film.getDescription();
        this.screenings = new HashSet<>();
        this.price = film.getPrice().toString();

        Iterator movies = film.getScreening().iterator();
        while(movies.hasNext())
        {
            ScreeningDTOForFilm scd = new ScreeningDTOForFilm((Screening) movies.next());
            screenings.add(scd);
        }
    }

    public FilmDTO() {

    }

    public Film toFilm()
    {
        Film film = new Film(this.title, this.duration);
        film.setDescription(this.description);

        return film;
    }
}
