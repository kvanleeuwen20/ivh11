package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.abstr.DomainObject;
import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

import static javax.persistence.LockModeType.PESSIMISTIC_READ;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQuery(
        name = "findMoviesByDuration",
        query = "SELECT f FROM Film f WHERE f.duration LIKE :duration ORDER BY f.duration",
        lockMode = PESSIMISTIC_READ
)
public class Film extends DomainObject
{
    @NotNull
    @NonNull
    @Size(min = 1, max = 255, message="{film.titleRightLength}")
    private String title;

    @NonNull
    @NotNull
    @Min(30)
    private int duration;

    @NotNull
    private BigDecimal price;

    private String description;

    @OneToMany(mappedBy = "film", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Screening> screening;

    @Tolerate
    public Film() {

    }
}
