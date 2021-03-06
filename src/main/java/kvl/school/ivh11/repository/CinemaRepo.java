package kvl.school.ivh11.repository;

import kvl.school.ivh11.domain.Cinema;

import java.util.List;

public interface CinemaRepo extends BaseRepo<Cinema, Long> {
   Cinema getCinemasById(Long id);

   List<Cinema> findCinemasByLocation(String location);
}
