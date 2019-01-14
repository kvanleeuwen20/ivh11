package kvl.school.ivh11.service;

import kvl.school.ivh11.repository.CinemaRepo;
import kvl.school.ivh11.domain.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService
{
    private final CinemaRepo cinemaRepo;

    @Autowired
    public CinemaService(CinemaRepo cinemaRepo)
    {
        this.cinemaRepo = cinemaRepo;
    }

    public Cinema findCinemasWithId(long id)
    {
        return cinemaRepo.getOne(id);
    }
}
