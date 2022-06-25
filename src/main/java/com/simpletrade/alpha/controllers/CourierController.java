package com.simpletrade.alpha.controllers;


import com.simpletrade.alpha.repository.OrderRepository;
import com.simpletrade.alpha.model.Order;
import com.simpletrade.alpha.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourierController {
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/courier_orders", method = RequestMethod.GET)
    public String courierOrders(Model model, Authentication authentication) {
        model.addAttribute("income_orders", orderRepository.getCourierOrdersIncome(2));
        model.addAttribute("active_orders", orderRepository.getCourierOrdersIncome(3));
        if (authentication != null) {
            model.addAttribute("user", authentication.getPrincipal());
        }
        return "courier_orders";
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model) {
        model.addAttribute("order", orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("order not found")));

        return "courier_order_details";
    }

    @GetMapping("/confirm_order/{id}")
    public String confirm(@PathVariable Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("order not found"));
        order.setStatus(new Status(3));

        orderRepository.save(order);

        return "redirect:/details/" + id;
    }
}
