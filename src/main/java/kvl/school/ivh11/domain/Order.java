package kvl.school.ivh11.domain;

import java.util.Observable;

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
public class Order extends Observable implements Serializable
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    @Setter(AccessLevel.NONE)
    private Long version;

    @NonNull
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private OrderState state;

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

    public void setState(OrderState state)
    {
        this.state = state;
        this.setChanged();
        this.notifyObservers(state);
    }

    public OrderState getOrderState()
    {
        return state;
    }


    @Tolerate
    public Order() {
        
    }

}
