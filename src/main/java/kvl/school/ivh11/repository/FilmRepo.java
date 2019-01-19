package kvl.school.ivh11.repository;

import kvl.school.ivh11.domain.Film;
import kvl.school.ivh11.domain.Screening;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface FilmRepo extends BaseRepo<Film, Long>
{
    @Query("SELECT f FROM Film f INNER JOIN f.screening s WHERE s.startTime >= :date")
    Set<Film> getFilmsPlayingToday(@Param("date") LocalDateTime date);
}
