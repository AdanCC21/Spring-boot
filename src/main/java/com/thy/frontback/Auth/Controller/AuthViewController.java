package com.thy.frontback.Auth.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/auth")
public class AuthViewController {
    public AuthViewController(){

    }

    @GetMapping
    public String LogIn() {
        return "auth/auth";
    }
    
    @GetMapping("/reg")
    public String Reg() {
        return "auth/reg";
    }
    
}
