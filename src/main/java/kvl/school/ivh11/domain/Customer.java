package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.abstr.AppUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Tolerate;
import javax.validation.constraints.Pattern;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends AppUser
{
    @Pattern(regexp = "\\\\d{3}-\\\\d{7}")
    @NonNull
    @NotNull
    @Size(min=1,max=10)
    private String mobNr;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Order> orders;

    @Tolerate
    public Customer() {
        super();
    }
}
