package kvl.school.ivh11.domain;

import java.util.Observable;

import kvl.school.ivh11.domain.abstr.OrderStateIF;
import kvl.school.ivh11.domain.impl.OrderCreated;
import lombok.*;
import lombok.experimental.Tolerate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Transactional(isolation=Isolation.READ_COMMITTED)
public abstract class Order extends Observable implements Serializable
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    @NonNull
    @Setter(AccessLevel.NONE)
    @Embedded
    private OrderStateIF state;

    @NonNull
    @NotNull
    @ManyToOne
    private Customer customer;

    @NonNull
    @NotNull
    private LocalDateTime orderTime;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

    public void setState(OrderStateIF state)
    {
        this.state = state;
        this.setChanged();
        this.notifyObservers(state);
    }

    @Tolerate
    public Order() {
        this.setState(new OrderCreated());
    }

}
