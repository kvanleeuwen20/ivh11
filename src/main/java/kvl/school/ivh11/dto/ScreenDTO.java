package kvl.school.ivh11.dto;

import kvl.school.ivh11.domain.Screen;

public class ScreenDTO
{
    private int maxSeats;
    private int size;

    public ScreenDTO(Screen screen)
    {
        this.maxSeats = screen.getMaxSeats();
        this.size = screen.getSize();
    }
}
