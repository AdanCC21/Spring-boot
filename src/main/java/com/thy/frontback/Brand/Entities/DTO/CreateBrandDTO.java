package com.thy.frontback.Brand.Entities.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.thy.frontback.Location.Entities.Location;
import com.thy.frontback.Product.Entities.Product;

public class CreateBrandDTO {

    private String name;

    private Location location;

    private LocalDate created = LocalDate.now();

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    private List<Product> products = new ArrayList<>();

    public CreateBrandDTO(String name, Location location, LocalDate created) {
        this.name = name;
        this.location = location;
        this.created = created;
    }

    public CreateBrandDTO(String name, Location location, LocalDate created, List<Product> products) {
        this.name = name;
        this.location = location;
        this.created = created;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
