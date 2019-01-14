package kvl.school.ivh11.service;

import kvl.school.ivh11.domain.*;
import kvl.school.ivh11.domain.Impl.MovieOrder;
import kvl.school.ivh11.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{
    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
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
