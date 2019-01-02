package kvl.school.ivh11.services;

public class PaymentStateOrginator
{
    private String currentPaymentState;

    public void setState(String paymentState)
    {
        this.currentPaymentState = paymentState;
    }

    public String getPaymentState()
    {
        return currentPaymentState;
    }

    public PaymentState saveStateToMemento()
    {
        return new PaymentState(currentPaymentState);
    }

    public void getStateFromMemento(PaymentState paymentState)
    {
        this.currentPaymentState = paymentState.getState();
    }
}
