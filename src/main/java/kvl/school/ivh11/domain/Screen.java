package kvl.school.ivh11.domain;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table
@Data
//zaal
public class Screen
{
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private int size;

    @Getter
    @Setter
    private int maxSeats;

    @Getter
    @Setter
    @OneToMany(mappedBy = "screen")
    private List<Screening> screening;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
}
