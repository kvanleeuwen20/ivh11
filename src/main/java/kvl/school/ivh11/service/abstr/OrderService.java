package kvl.school.ivh11.service.abstr;

import kvl.school.ivh11.domain.Order;

public interface OrderService
{
    void createOrder(Order order);
    String getCheckOutUrl(); 
}
