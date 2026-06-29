package com.thy.frontback.Product.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thy.frontback.Product.Service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductViewController {
    private final ProductService service;

    public ProductViewController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String HomePage(Model model) {
        model.addAttribute("productList", this.service.getAll());
        return "products/home";
    }

    @GetMapping("/add")
    public String AddProduct() {
        return "products/AddProduct";
    }
}
