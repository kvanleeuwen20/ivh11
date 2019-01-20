package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.abstr.DomainObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Cinema extends DomainObject
{
    @NotNull
    @NonNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    @NonNull
    private String location;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Screen> screens;

    @Tolerate
    public Cinema()
    {

    }
}
