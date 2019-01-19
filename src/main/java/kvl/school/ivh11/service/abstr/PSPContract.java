package kvl.school.ivh11.service.abstr;

import kvl.school.ivh11.domain.Order;

import java.util.HashMap;

public interface PSPContract
{
    void setConfigParams(HashMap<String, String> cnf);
    void setOrder(Order o);
}
