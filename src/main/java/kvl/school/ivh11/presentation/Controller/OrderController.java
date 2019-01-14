package kvl.school.ivh11.presentation.Controller;

import kvl.school.ivh11.domain.Screening;
import kvl.school.ivh11.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController
{
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @GetMapping("/getTickets")
    public String getAvailabileScreenings(@RequestParam(name="mvid", required=true, defaultValue=0) String mvid, Model model) {
        model.addAttribute("name", mvid);
        return "greeting";
    }

    @PostMapping(value = "/checkout")
    public ModelAndView addTicketToOrder(@ModelAttribute Screening screen)
    {
        orderService.addTicket(screen);
    }

    public ModelAndView getOrderSummary()
    {
        return "summary"
    }
}
