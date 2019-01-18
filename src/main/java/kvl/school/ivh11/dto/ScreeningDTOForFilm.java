package kvl.school.ivh11.dto;

import kvl.school.ivh11.domain.Screening;

import java.time.LocalDateTime;

public class ScreeningDTOForFilm
{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ScreenDTO screen;

    public ScreeningDTOForFilm(Screening screening)
    {
        this.startTime = screening.getStartTime();
        this.endTime = screening.getEndTime();
        this.screen = new ScreenDTO(screening.getScreen());
    }
}
