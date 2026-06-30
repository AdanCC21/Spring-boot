package com.thy.frontback.Product.Entities.DTO;

public class UpdateProductDTO {    
    private Long price;


    private String title;

    private String image;

    public UpdateProductDTO(Long price, String title, String image) {
        this.price = price;
        this.title = title;
        this.image = image;
    }

    public UpdateProductDTO(Long price, String title) {
        this.price = price;
        this.title = title;
    }

    public UpdateProductDTO() {
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

    
}
