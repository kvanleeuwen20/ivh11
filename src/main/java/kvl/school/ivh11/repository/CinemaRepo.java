package kvl.school.ivh11.repository;

import kvl.school.ivh11.domain.Cinema;
import org.springframework.stereotype.Component;

public interface CinemaRepo extends BaseRepo<Cinema, Long>
{
   Cinema getCinemasById(Long id);
}