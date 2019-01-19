package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.service.PaymentResult;

public class MolliePSP extends JSONPaymentProcessorImpl
{
    private String name;

    @Override
    protected void completeRequest(PaymentResult result)
    {
        //send mail and show message

    }
}