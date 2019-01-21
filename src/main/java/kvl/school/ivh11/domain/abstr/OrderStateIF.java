package kvl.school.ivh11.domain.abstr;

import kvl.school.ivh11.domain.Order;

public interface OrderStateIF
{
    void processAction(Order order);
}