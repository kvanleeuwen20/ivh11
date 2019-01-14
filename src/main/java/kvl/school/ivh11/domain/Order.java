package kvl.school.ivh11.domain;


import java.util.Observable;

import lombok.*;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table
@Transactional
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Order extends Observable implements Serializable
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private transient Set<Ticket> tickets;

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
