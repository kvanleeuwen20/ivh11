package kvl.school.ivh11.domain;


import java.util.Observable;

import kvl.school.ivh11.service.abstr.PaymentProvider;
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
@Table
@Transactional(isolation=Isolation.READ_COMMITTED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = false)
public class Order extends Observable implements Serializable
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Version
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

    private PaymentProvider pAymentProvider;


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

    public void setPaymentProvider(PaymentProvider provider)
    {
        this.pAymentProvider = provider;
    }

    public PaymentProvider getpAymentProvider()
    {
        return pAymentProvider;
    }

    @Tolerate
    public Order() {
        
    }

}
