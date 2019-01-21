package kvl.school.ivh11.web.controller;

import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.Payment;
import kvl.school.ivh11.domain.Screening;
import kvl.school.ivh11.service.abstr.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

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
        return null;
    }

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public void processOrder(HttpServletResponse httpServletResponse, Order order)
    {
        orderService.createOrder(order);
        httpServletResponse.setHeader("Location", orderService.getCheckOutUrl());
        httpServletResponse.setStatus(302);
    }
}
