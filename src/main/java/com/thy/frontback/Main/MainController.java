package com.thy.frontback.Main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.thy.frontback.User.Service.UserService;

@Controller
public class MainController {

    private final UserService service;

    public MainController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("user", service.getUser(1));
        model.addAttribute("users", service.getAll());
        
        return "index";
    }
}
