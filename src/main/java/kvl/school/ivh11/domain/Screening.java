package kvl.school.ivh11.domain;

import lombok.*;
import lombok.experimental.Tolerate;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table

/**
 * Vertoning
 */
public class Screening
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NonNull
    private LocalDateTime startTime;

    @NotNull
    @NonNull
    private LocalDateTime endTime;

    @NotNull
    @NonNull
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Film film;

    @NotNull
    @NonNull
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Screen screen;

    @Tolerate
    public Screening() {

    }
}
