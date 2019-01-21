package kvl.school.ivh11.web.controller;

import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.Payment;
import kvl.school.ivh11.domain.Screening;
import kvl.school.ivh11.domain.impl.MovieOrder;
import kvl.school.ivh11.service.abstr.OrderService;
import kvl.school.ivh11.service.impl.JSONPaymentProcessorImpl;
import kvl.school.ivh11.service.impl.MolliePSP;
import kvl.school.ivh11.service.impl.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController
{
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @GetMapping("/getTickets")
    public String getAvailableScreenings(@RequestParam(name="mvID", required=true, defaultValue = "-1") String myID, Model model) {
        model.addAttribute("name", myID);
        return "greeting";
    }

    @PostMapping(value = "/checkout")
    public ModelAndView addTicketToOrder(@ModelAttribute Screening screen)
    {
        orderService.addTicket(screen);
        return null;
    }

    public ModelAndView processOrder(MovieOrder order)
    {
        // TODO
        order.getOrder().getState().processAction(order);
        PaymentProxy p = new PaymentProxy();
        JSONPaymentProcessorImpl jsonCallBackImpl = new JSONPaymentProcessorImpl();
        p.createNewPayment(new Payment(new MolliePSP(jsonCallBackImpl), order));
        String returnUrl = p.getCheckOutUrl();

        return null;
    }
}
