package kvl.school.ivh11.domain.impl;

import kvl.school.ivh11.domain.abstr.OrderStateIF;

public class OrderPending implements OrderStateIF
{
    @Override
    public void processAction(MovieOrder order)
    {
        order.getOrder().setState(new OrderPaid());
    }
}
