package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.service.PaymentResult;
import kvl.school.ivh11.service.abstr.PaymentProviderIssuer;

public class MolliePSP extends PaymentProviderIssuer
{
    @Override
    protected void completeRequest(PaymentResult result)
    {
        //send mail and show message

    }
}