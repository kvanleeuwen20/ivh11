package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.service.abstr.PaymentProvider;

public class MolliePSP extends PaymentProvider
{
    private JSONPaymentProcessorImpl jsonPaymentProcessor;

    public MolliePSP(JSONPaymentProcessorImpl jsonPaymentProcessor)
    {
        this.jsonPaymentProcessor = jsonPaymentProcessor;
    }

    @Override
    public String getCheckOutUrl()
    {
        return jsonPaymentProcessor.getCheckOutUrl(this.getOrder());
    }
}