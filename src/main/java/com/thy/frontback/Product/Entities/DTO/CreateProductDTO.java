package com.thy.frontback.Product.Entities.DTO;

import jakarta.persistence.Column;

public class CreateProductDTO {
    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String Brand;

    @Column(nullable = true)
    private String Image;

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

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
