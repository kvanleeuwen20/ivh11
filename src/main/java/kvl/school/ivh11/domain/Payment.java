package kvl.school.ivh11.domain;

import kvl.school.ivh11.service.abstr.PaymentProvider;

public class Payment
{
    private PaymentProvider paymentProvider;
    private Order order;

    public Payment(PaymentProvider paymentProvider, Order order)
    {
        this.paymentProvider = paymentProvider;
        this.order = order;
    }

    public Order getOrder()
    {
        return order;
    }

    public PaymentProvider getPaymentProvider()
    {
        return paymentProvider;
    }
}
