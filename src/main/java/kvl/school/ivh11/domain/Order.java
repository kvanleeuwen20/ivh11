package kvl.school.ivh11.domain;


import java.util.Observable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.*;

@Entity
@Data
@Table
public class Order extends Observable implements Serializable
{
    private OrderState orderState;

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    private OrderState state;

    @Getter
    @Setter
    private LocalDateTime orderTime;

    @OneToMany
    private Set<Ticket> tickets;

    public void setState(OrderState state)
    {
        this.orderState = state;
        this.setChanged();
        this.notifyObservers(state);
    }

    public OrderState getOrderState()
    {
        return orderState;
    }

}
