package kvl.school.ivh11.service;

import java.time.LocalDateTime;

public class PaymentResult
{
    private PaymentState paymentState;
    private String trixid;
    private LocalDateTime dateTime;

    public void PaymenResult(LocalDateTime dateTime, String trixid, PaymentState state)
    {
        this.trixid   = trixid;
        this.dateTime = dateTime;
        PaymentStateHandler psh = new PaymentStateHandler();
        psh.setState(state);
        this.paymentState = state;
    }

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
