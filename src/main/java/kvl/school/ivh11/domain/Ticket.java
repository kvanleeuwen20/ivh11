package kvl.school.ivh11.domain;

import kvl.school.ivh11.domain.abstr.DomainObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Ticket extends DomainObject
{
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
