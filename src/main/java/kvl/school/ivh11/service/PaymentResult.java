package kvl.school.ivh11.service;

import kvl.school.ivh11.domain.Payment;

import java.time.LocalDateTime;

public class PaymentResult
{
    private Payment payment;
    private PaymentState paymentState;
    private String trixid;
    private LocalDateTime dateTime;

    public void PaymenResult(LocalDateTime dateTime, String trixid, Payment payment, PaymentState state)
    {
        this.payment  = payment;
        this.trixid   = trixid;
        this.dateTime = dateTime;
        PaymentStateHandler psh = new PaymentStateHandler();
        psh.setState(state);
        this.paymentState = state;
    }

    public Payment getPayment() { return payment; }

    public String getTrixId()
    {
        return trixid;
    }

    public LocalDateTime getDateTime()
    {
        return dateTime;
    }

    public PaymentState getState()
    {
        return paymentState;
    }
}
