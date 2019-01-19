package kvl.school.ivh11.service.abstr;

import kvl.school.ivh11.dto.FilmDTO;

import java.time.LocalDateTime;
import java.util.Set;

public interface FilmService
{
    Set<FilmDTO> getFilms();
    Set<FilmDTO> getFilmsPlayingToday(LocalDateTime date);
    Long addFilm(FilmDTO filmDto);
}
