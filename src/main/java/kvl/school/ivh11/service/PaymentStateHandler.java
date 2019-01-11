package kvl.school.ivh11.service;

import java.util.HashMap;

public class PaymentStateHandler
{
    private HashMap<Integer, PaymentState> paymentStateHistory = new HashMap<Integer, PaymentState>();

    public void setState(PaymentState state)
    {
        int posnr  = paymentStateHistory.size() + 1;
        paymentStateHistory.put(posnr, state);
    }

    public PaymentState get(int historyMoment)
    {
        return paymentStateHistory.get(historyMoment);
    }
}
