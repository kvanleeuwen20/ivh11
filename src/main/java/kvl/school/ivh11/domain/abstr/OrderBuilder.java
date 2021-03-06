package kvl.school.ivh11.domain.abstr;

import kvl.school.ivh11.domain.Customer;
import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.Screening;
import kvl.school.ivh11.domain.Seat;

public abstract class OrderBuilder
{
    protected Order order;

    public Order getOrder()
    {
        return order;
    }

    public void createNewOrder()
    {
    }

    public abstract void setScreening(Long tid, Screening screening);
    public abstract void setCustomer(long oid, Customer customer);
    public abstract void addSeat(long oid, Seat seat);
}
