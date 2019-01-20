package kvl.school.ivh11.domain;

import com.sun.istack.NotNull;
import kvl.school.ivh11.domain.Abstr.DomainObject;
import lombok.*;
import lombok.experimental.Tolerate;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@ToString(exclude = "screens")
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EqualsAndHashCode(callSuper = false)
public class Cinema extends DomainObject
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @NotNull
    @NonNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @NonNull
    private String location;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private transient Set<Screen> screens;

    @Tolerate
    public Cinema()
    {

    }
}
