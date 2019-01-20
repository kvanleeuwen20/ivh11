package kvl.school.ivh11.domain.Impl;

import kvl.school.ivh11.domain.*;
import kvl.school.ivh11.domain.abstr.OrderBuilder;
import kvl.school.ivh11.repository.OrderRepo;
import kvl.school.ivh11.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieOrder extends OrderBuilder
{
    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    OrderRepo orderRepo;

    public void addTicket(Ticket ticket)
    {
        order.getTickets().add(ticket);
    }

    @Override
    public void addSeat(long tid, Seat seat)
    {
        Ticket ticket = ticketRepo.getOne(tid);
        if(ticket != null)
        {
           ticket.setSeat(seat);
        }
    }

    public void setScreening(Long tid, Screening screening)
    {
        Ticket ticket = ticketRepo.getOne(tid);
        if(ticket != null)
        {
            ticket.setScreening(screening);
        }
    }

    @Override
    public void setCustomer(long oid, Customer customer)
    {
        Order order = orderRepo.getOne(oid);
        if(order != null)
        {
            order.setCustomer(customer);
        }
    }
}
