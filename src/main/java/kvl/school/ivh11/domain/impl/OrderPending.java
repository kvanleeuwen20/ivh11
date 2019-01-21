package kvl.school.ivh11.domain.impl;

import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.abstr.OrderStateIF;

public class OrderPending implements OrderStateIF
{
    @Override
    public void processAction(Order order)
    {
        order.setState(new OrderPaid());
    }
}
