package kvl.school.ivh11.domain.Abstr;

import kvl.school.ivh11.domain.Order;

public abstract class OrderBuilder
{
    protected Order order;

    public Order getOrder()
    {
        return order;
    }

    public void createNewOrder()
    {
        order = new Order();
    }

    public abstract void setScreening();
    public abstract void setCustomer();
    public abstract void addSeat();
}
