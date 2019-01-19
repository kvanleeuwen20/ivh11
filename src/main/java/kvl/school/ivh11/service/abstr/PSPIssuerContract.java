package kvl.school.ivh11.service.abstr;

import kvl.school.ivh11.service.PaymentResult;

import java.util.HashMap;

public interface PSPIssuerContract
{
    void setName(String name);
    String getName();
    void processResult(HashMap<String, String> cnf, PaymentResult result);
}
