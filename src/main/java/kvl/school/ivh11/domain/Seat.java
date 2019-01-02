package kvl.school.ivh11.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import javax.persistence.*;

@Entity
@Data
@Table
public class Seat
{
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter
    @Setter
    private int seatNr;

    @Getter
    @Setter
    private boolean isVIP;

    @OneToMany(mappedBy = "seat")
    private Set<Ticket> tickets;

    @ManyToOne
    private Screen screen;
}
