package com.thy.frontback.Product.Entities.DTO;

public class CreateProductDTO {
    private Long price;

    private String title;

    private Long brandId;

    private String image;

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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    

    public CreateProductDTO() {
    }

    public CreateProductDTO(Long price, String title, Long brandId, String image) {
        this.price = price;
        this.title = title;
        this.brandId = brandId;
        this.image = image;
    }

    public CreateProductDTO(Long price, String title, Long brandId) {
        this.price = price;
        this.title = title;
        this.brandId = brandId;
    }    
}
