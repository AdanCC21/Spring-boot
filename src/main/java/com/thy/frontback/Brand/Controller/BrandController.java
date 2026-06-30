package com.thy.frontback.Brand.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thy.frontback.Brand.Entities.Brand;
import com.thy.frontback.Brand.Service.BrandService;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
    private final BrandService service;

    public BrandController(BrandService service){
        this.service = service;
    }

    @GetMapping
    public List<Brand> getAll(){
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Brand getById(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }
}
