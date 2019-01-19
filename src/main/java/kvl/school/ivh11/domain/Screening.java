package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.Abstr.DomainObject;
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
@EqualsAndHashCode(callSuper = false)
public class Screening extends DomainObject
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Screen screen;

    @Tolerate
    public Screening() {

    }
}
