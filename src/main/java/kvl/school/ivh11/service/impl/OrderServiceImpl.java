package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.exception.OrderException;
import kvl.school.ivh11.domain.*;
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
    private String checkOutUrl;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public void createOrder(Order order)
    {
        order.getState().processAction(order);
        PaymentProxy p = new PaymentProxy();
        JSONPaymentProcessorImpl jsonCallBackImpl = new JSONPaymentProcessorImpl();
        p.createNewPayment(new Payment(new MolliePSP(jsonCallBackImpl), order));
        this.checkOutUrl = p.getCheckOutUrl();
    }

    public String getCheckOutUrl()
    {
        return checkOutUrl;
    }
}
