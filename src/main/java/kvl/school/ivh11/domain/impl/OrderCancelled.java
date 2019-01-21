package kvl.school.ivh11.domain.impl;

import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.abstr.OrderStateIF;

import javax.naming.Context;

public class OrderCancelled implements OrderStateIF
{
    @Override
    public void processAction(Order order)
    {
        //do something
    }
}
