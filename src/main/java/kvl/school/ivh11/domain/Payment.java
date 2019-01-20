package kvl.school.ivh11.domain;

import kvl.school.ivh11.service.abstr.PaymentProvider;
import lombok.Data;

@Data
public class Payment
{
    private final PaymentProvider paymentProvider;
    private final Order order;
}
