package com.simpletrade.alpha.controllers;


import com.simpletrade.alpha.OrderRepository;
import com.simpletrade.alpha.OrderStatusRepository;
import com.simpletrade.alpha.model.Role;
import com.simpletrade.alpha.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourierController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @RequestMapping(value = "/courier_orders", method = RequestMethod.GET)
    public String courierOrders(Model model, Authentication authentication) {
        model.addAttribute("orders", orderRepository.getCourierOrdersIncome());
        model.addAttribute("options", new String[]{"1", "2", "3", "4"});
        if (authentication != null) {
            model.addAttribute("user", authentication.getPrincipal());
        }
        return "courier_orders";
    }
}
