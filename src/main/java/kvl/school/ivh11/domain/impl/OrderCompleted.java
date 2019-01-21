package kvl.school.ivh11.domain.impl;

import kvl.school.ivh11.domain.abstr.OrderStateIF;

import javax.naming.Context;

public class OrderCompleted implements OrderStateIF
{
    @Override
    public void processAction(MovieOrder order) {
        order.getOrder().setState(this);
    }
}
