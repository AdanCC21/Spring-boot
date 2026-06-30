package com.thy.frontback.Product.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.thy.frontback.Brand.Entities.Brand;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = true)
    private String image;

    @ManyToOne
    @JoinColumn(name="brand_id", nullable = false)
    @JsonBackReference
    private Brand brand;

    public Product() {
    }

    public Product(Long price, String title, Brand brand) {
        this.price = price;
        this.title = title;
        this.brand = brand;
    }

    public Product(Long price, String title, String image, Brand brand) {
        this.price = price;
        this.title = title;
        this.image = image;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    
}
