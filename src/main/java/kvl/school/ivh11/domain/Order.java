package kvl.school.ivh11.domain;


import java.util.Observable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Data
@Table
@Transactional
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Order extends Observable implements Serializable
{
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Version
    private OrderState state;

    @ManyToOne
    private Customer customer;

    @Getter
    @Setter
    private LocalDateTime orderTime;

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

}
