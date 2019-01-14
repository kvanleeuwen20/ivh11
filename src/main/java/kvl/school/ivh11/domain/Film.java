package kvl.school.ivh11.domain;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@Table
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Film
{
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private long id;

    @NotNull
    @NonNull
    @Size(min = 1, max = 255, message="{film.titleRightLength}")
    private String title;

    @NotNull
    @NonNull
    @Min(30)
    @PositiveOrZero
    private int duration;

    private String description;

    @OneToMany(mappedBy = "film", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private transient Set<Screening> screening;

    @Tolerate
    public Film() {

    }
}
