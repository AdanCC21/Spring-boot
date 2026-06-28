package com.thy.frontback.User.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thy.frontback.User.Entities.User;
import com.thy.frontback.User.Service.UserService;

@Controller
@RequestMapping("/user")
public class UserViewController {
    private final UserService service;

    public UserViewController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String profile() {
        return "/user/profile";
    }

    @GetMapping("/admin")
    public String manageUsers(Model model) {
        model.addAttribute("users", service.getAll());

        return "/user/admin/manage";
    }
}
