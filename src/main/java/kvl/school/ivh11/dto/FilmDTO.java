package kvl.school.ivh11.dto;

import kvl.school.ivh11.domain.Film;
import java.io.Serializable;

public class FilmDTO implements Serializable {
    private String title;

    private int duration;

    private String description;

    public FilmDTO(Film film) {
        this.title = film.getTitle();
        this.duration = film.getDuration();
        this.description = film.getDescription();
    }

    public Film toFilm()
    {
        Film film = new Film();
        film.setDescription(this.description);
        film.setTitle(this.title);
        film.setDuration(this.duration);
        return film;
    }
}
