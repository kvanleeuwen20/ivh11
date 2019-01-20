package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.Abstr.AppUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Customer extends AppUser
{
    @Getter
    @Setter
    @Pattern(regexp = "\\\\d{3}-\\\\d{7}")
    private String mobNr;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private transient Set<Order> orders;

}
