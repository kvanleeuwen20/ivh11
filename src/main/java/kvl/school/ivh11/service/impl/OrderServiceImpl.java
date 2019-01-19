package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.Exception.OrderException;
import kvl.school.ivh11.domain.*;
import kvl.school.ivh11.domain.Impl.MovieOrder;
import kvl.school.ivh11.repository.OrderRepo;
import kvl.school.ivh11.service.abstr.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderService")
@Transactional(rollbackFor = OrderException.class)
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void addTicket(Screening screening)
    {
        MovieOrder mvo = new MovieOrder();
        Ticket ticket = new Ticket();
        ticket.setScreening(screening);
        mvo.addTicket(ticket);
        mvo.setCustomer(ticket.getId(), new Customer());
    }

}
