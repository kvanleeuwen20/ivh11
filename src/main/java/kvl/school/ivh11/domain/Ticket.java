package kvl.school.ivh11.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class Ticket
{
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Getter
    @Setter
    private BigDecimal price;

    @Getter
    @Setter
    private String description;

    @JoinColumn(name = "order_id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Screening screening;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Seat seat;
}
