package kvl.school.ivh11.domain.abstr;

import kvl.school.ivh11.domain.Order;

public abstract class OrderObserver
{
    protected Order order;
    public abstract void update();
}