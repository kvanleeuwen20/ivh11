package kvl.school.ivh11.service.abstr;


import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.service.PaymentResult;

import java.util.HashMap;

public abstract class JsonPaymentProcessorStrategy implements PSPIssuerContract
{
    public void processResult(HashMap<String, String> cnf, PaymentResult result)
    {
        setParams(cnf);
        completeRequest(result);
    }

    protected abstract void setParams(HashMap<String, String> cnf);
    protected abstract void completeRequest(PaymentResult result);
    protected abstract String getCheckOutUrl(Order o);

}
