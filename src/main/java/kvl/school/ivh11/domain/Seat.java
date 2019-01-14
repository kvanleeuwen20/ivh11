package kvl.school.ivh11.domain;

import lombok.*;
import lombok.experimental.Tolerate;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table
public class Seat
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NonNull
    private int seatNr;

    @NonNull
    private boolean isVIP;

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY)
    private transient Set<Ticket> tickets;

    @NotNull
    @NonNull
    @JoinColumn(name = "screen_id")
    @ManyToOne
    private Screen screen;

    @Tolerate
    public Seat() {

    }
}
