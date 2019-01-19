package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.repository.CinemaRepo;
import kvl.school.ivh11.domain.Cinema;
import kvl.school.ivh11.service.abstr.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cinemaService")
public class CinemaServiceImpl implements CinemaService
{
    @Autowired
    private CinemaRepo cinemaRepo;

    public CinemaServiceImpl(CinemaRepo cinemaRepo)
    {
        this.cinemaRepo = cinemaRepo;
    }

    public Cinema findCinemasWithId(long id)
    {
        return cinemaRepo.getOne(id);
    }
}
