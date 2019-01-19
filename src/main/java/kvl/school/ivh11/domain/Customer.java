package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.Abstr.AppUser;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Customer extends AppUser
{
    @Getter
    @Setter
    private String mobNr;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private transient Set<Order> orders;
}
