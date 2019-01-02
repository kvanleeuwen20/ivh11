package kvl.school.ivh11.repositories.abstr;

import kvl.school.ivh11.domain.Cinema;
import org.springframework.stereotype.Component;

@Component
public interface CinemaRepo extends BaseRepo<Cinema, Long>
{
   Cinema getCinemasById(Long id);
}
