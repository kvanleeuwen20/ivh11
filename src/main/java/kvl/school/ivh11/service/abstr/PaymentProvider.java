package kvl.school.ivh11.service.abstr;

import com.jayway.jsonpath.JsonPath;
import kvl.school.ivh11.domain.Order;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class PaymentProvider implements PSPContract
{
    protected HashMap<String, String> cnf;
    private Order order;

    public void setConfigParams(HashMap<String, String> cnf)
    {
        this.cnf = cnf;
    }


    public void setOrder(Order o)
    {
        this.order = o;
    }

    public boolean canCheckout()
    {
        return cnf.containsKey("apiHost") && cnf.containsKey("apiKey");
    }
}
