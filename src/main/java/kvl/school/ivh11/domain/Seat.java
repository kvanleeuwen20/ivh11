package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.abstr.DomainObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Seat extends DomainObject
{
    @NotNull
    @NonNull
    private int seatNr;

    @NonNull
    private boolean isVIP;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

    @NotNull
    @NonNull
    @JoinColumn(name = "screen_id")
    @ManyToOne
    private Screen screen;

    @Tolerate
    public Seat() {

    }
}
