package kvl.school.ivh11.domain;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

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
    @OneToMany(mappedBy = "screen", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Screening> screening;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Cinema cinema;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Seat> seats;
}
