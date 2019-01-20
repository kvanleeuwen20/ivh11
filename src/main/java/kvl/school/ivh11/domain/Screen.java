package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.abstr.DomainObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Transactional
public class Screen extends DomainObject
{
    @NonNull
    @NotNull
    @Size(min = 1, max = 255)
    private String room;

    @NonNull
    @NotNull
    @Min(10)
    private int size;

    @NonNull
    @NotNull
    @Min(10)
    private int maxSeats;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Screening> screening;

    @NotNull
    @NonNull
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Cinema cinema;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "screen", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Seat> seats;

    @Tolerate
    public Screen() {

    }
}
