package kvl.school.ivh11.domain;

import lombok.*;
import lombok.experimental.Tolerate;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table
@Data
@Transactional
//zaal
public class Screen
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private LocalDate date;

    @NotNull
    @Size(min = 1, max = 255)
    private String room;

    @NotNull
    @NonNull
    private int size;

    @NotNull
    @NonNull
    private int maxSeats;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Screening> screening;

    @NotNull
    @NonNull
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Cinema cinema;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private transient Set<Seat> seats;

    @Tolerate
    public Screen() {

    }
}
