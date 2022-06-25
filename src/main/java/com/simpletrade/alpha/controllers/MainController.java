package com.simpletrade.alpha.controllers;

import com.simpletrade.alpha.repository.PossibleModelRepository;
import com.simpletrade.alpha.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    PossibleModelRepository possibleModelRepository;
/*    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("title", "simpletrade");
        return "home";
    }*/

    @GetMapping("/")
    public String home(Authentication auth) {
        if (auth != null && auth.getAuthorities().contains(new Role(1, null))) {
            return "redirect:/client";
        }
        if(auth != null && auth.getAuthorities().contains(new Role(2, null))){
            return "redirect:/admin";
        }
        if(auth != null && auth.getAuthorities().contains(new Role(3, null))){
            return "redirect:/courier_orders";
        }
            else {
            return "redirect:/home";
        }
    }
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model, Authentication authentication) {
        if (authentication != null) {
            model.addAttribute("user", authentication.getPrincipal());
        }
        return "home";
    }
//

/*    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model, Authentication authentication) {
        model.addAttribute("models", possibleModelRepository.findAll());
        model.addAttribute("options", new String[]{"1", "2", "3", "4"});
        if (authentication != null) {
            model.addAttribute("user", authentication.getPrincipal());
        }
        return "home";
    }*/

}
