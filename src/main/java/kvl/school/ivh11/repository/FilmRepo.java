package kvl.school.ivh11.repository;

import kvl.school.ivh11.domain.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Set;

public interface FilmRepo extends BaseRepo<Film, Long>
{
    @Query("SELECT f FROM Film f INNER JOIN f.screening s WHERE s.startTime >= :date")
    Set<Film> getFilmsPlayingToday(@Param("date") LocalDateTime date);
}
