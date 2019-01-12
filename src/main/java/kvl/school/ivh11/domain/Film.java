package kvl.school.ivh11.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    @Getter
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    @NotNull
    @Size(min = 1, max = 255, message="{film.titleRightLength}")
    private String title;

    @Getter
    @Setter
    @NotNull
    @Min(30)
    @PositiveOrZero
    private int duration;

    @Getter
    @Setter
    private String description;

    @OneToMany(mappedBy = "film", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Screening> screening;

}
