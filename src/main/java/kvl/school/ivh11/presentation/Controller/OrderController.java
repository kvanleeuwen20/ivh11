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

    public ModelAndView getOrderSummary()
    {
        // TODO
        return null;
    }
}
