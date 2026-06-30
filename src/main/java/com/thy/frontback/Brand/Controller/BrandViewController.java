package com.thy.frontback.Brand.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thy.frontback.Brand.Service.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandViewController {
    private final BrandService service;

    public BrandViewController(BrandService service) {
        this.service = service;
    }

    @GetMapping
    public String home (Model model){
        model.addAttribute("brands", service.getAll());
        return "brands/home";
    }
}
