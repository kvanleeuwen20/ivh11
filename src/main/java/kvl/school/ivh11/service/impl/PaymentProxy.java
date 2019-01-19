package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.OrderState;
import kvl.school.ivh11.domain.Payment;
import kvl.school.ivh11.service.abstr.PSPContract;
import java.util.HashMap;

public class PaymentProxy implements PSPContract
{
    private Payment payment;

    public boolean createNewPayment(Payment payment)
    {
        this.payment = payment;
    }

    public String getCheckOutUrl(Payment payment)
    {
        String response = "";
        if(payment.getOrder().getOrderState() == OrderState.PENDING)
            response = "wait";
        else
            if(payment.getPaymentProvider().canCheckout())
            {
                MolliePSP m = new MolliePSP();
                String url = m.getCheckOutUrl(payment.getOrder());
            }

        return response;
    }

    @Override
    public void setConfigParams(HashMap<String, String> cnf)
    {
        payment.getPaymentProvider().setConfigParams(cnf);
    }

    @Override
    public void setOrder(Order o) {

    }
}
