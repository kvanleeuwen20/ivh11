package kvl.school.ivh11.domain;

import lombok.*;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table
@Data
public class Ticket
{
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @NonNull
    private BigDecimal price;

    private String description;

    @NotNull
    @NonNull
    @JoinColumn(name = "order_id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Order order;

    @NotNull
    @NonNull
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Screening screening;

    @NotNull
    @NonNull
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Seat seat;

    @Tolerate
    public Ticket() {

    }
}
