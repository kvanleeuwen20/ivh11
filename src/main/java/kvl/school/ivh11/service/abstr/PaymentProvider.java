package kvl.school.ivh11.service.abstr;

import kvl.school.ivh11.domain.im
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public abstract class PaymentProvider implements PSPContract
{
    protected HashMap<String, String> cnf;
    private kvl.school.ivh11.domain.impl.MovieOrder order;

    @Getter
    @Setter
    protected String name;

    public void setConfigParams(HashMap<String, String> cnf)
    {
        this.cnf = cnf;
    }

    public void setOrder(kvl.school.ivh11.domain.impl.MovieOrder o)
    {
        this.order = o;
    }
    protected final kvl.school.ivh11.domain.impl.MovieOrder getOrder() { return order; }

    protected boolean canCheckout()
    {
        return cnf.containsKey("apiHost") && cnf.containsKey("apiKey");
    }

    public abstract String getCheckOutUrl();
}
