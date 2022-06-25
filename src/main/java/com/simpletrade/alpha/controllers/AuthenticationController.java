package com.simpletrade.alpha.controllers;

import com.simpletrade.alpha.repository.UserRepository;
import com.simpletrade.alpha.model.Role;
import com.simpletrade.alpha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@RequestParam String email, @RequestParam String password,
                                 @RequestParam String firstName, @RequestParam String lastName,
                                 @RequestParam String fatherName, @RequestParam String phone) {
        Role role = new Role();
        role.setId(1);
        User user = new User(firstName, lastName, fatherName, email, phone, passwordEncoder.encode(password), role);
        userRepository.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
