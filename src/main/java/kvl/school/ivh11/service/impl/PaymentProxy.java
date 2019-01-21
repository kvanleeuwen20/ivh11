package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.domain.OrderState;
import kvl.school.ivh11.domain.Payment;
import kvl.school.ivh11.service.abstr.PSPContract;
import java.util.HashMap;

public class PaymentProxy implements PSPContract
{
    private Payment payment;

    public void createNewPayment(Payment payment)
    {
        this.payment = payment;
    }

    public String getCheckOutUrl()
    {
        String response;
        if(payment.getOrder().getOrder().getState() == OrderState.PENDING)
            response = "wait";
        else{
            response = payment.getPaymentProvider().getCheckOutUrl();
            if(response.length() < 2)
                response = "error";
        }
        return response;
    }

    @Override
    public void setConfigParams(HashMap<String, String> cnf)
    {
        payment.getPaymentProvider().setConfigParams(cnf);
    }
}
