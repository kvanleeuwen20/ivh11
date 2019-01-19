package kvl.school.ivh11.service.abstr;

import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.service.PaymentResult;

import java.util.HashMap;

public abstract class XmlPamentProcessorStrategy implements PSPIssuerContract
{
    public void processResult(HashMap<String, String> cnf, PaymentResult result)
    {
        completeRequest(cnf, result);
    }
    protected abstract void completeRequest(HashMap<String, String> cnf, PaymentResult result);

    protected abstract String getCheckOutUrl(Order o);
}
