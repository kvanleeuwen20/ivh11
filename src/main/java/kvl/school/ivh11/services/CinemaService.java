package kvl.school.ivh11.services;

import kvl.school.ivh11.repositories.abstr.CinemaRepo;
import kvl.school.ivh11.domain.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService
{
    @Autowired
    private CinemaRepo cinemaRepo;

    public CinemaService()
    {

    }

    public Cinema findCinemasWithId(long id)
    {
        return cinemaRepo.getCinemasById(id);
    }
}
