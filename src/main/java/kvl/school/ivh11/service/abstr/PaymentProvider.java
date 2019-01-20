package kvl.school.ivh11.service.abstr;

import kvl.school.ivh11.domain.impl.MovieOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public abstract class PaymentProvider implements PSPContract
{
    protected HashMap<String, String> cnf;
    private MovieOrder order;

    @Getter
    @Setter
    protected String name;

    public void setConfigParams(HashMap<String, String> cnf)
    {
        this.cnf = cnf;
    }

    public void setOrder(MovieOrder o)
    {
        this.order = o;
    }
    protected final MovieOrder getOrder() { return order; }

    protected boolean canCheckout()
    {
        return cnf.containsKey("apiHost") && cnf.containsKey("apiKey");
    }

    public abstract String getCheckOutUrl();
}
