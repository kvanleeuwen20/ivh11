package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.abstr.DomainObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
/**
 * Vertoning
 */
public class Screening extends DomainObject
{
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
