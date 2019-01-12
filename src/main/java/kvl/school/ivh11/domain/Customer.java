package kvl.school.ivh11.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
@Data
public class Customer extends User
{
    @OneToOne(mappedBy = "order", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Order> orders;
}
