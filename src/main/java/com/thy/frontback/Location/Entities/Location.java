package com.thy.frontback.Location.Entities;

import com.thy.frontback.Brand.Entities.Brand;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String country;
    
    @Column
    private String state;
    
    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    
    public Location() {
    }

    public Location(String country, String state) {
        this.country = country;
        this.state = state;
    }

    public Location(String country, String state, Brand brand) {
        this.country = country;
        this.state = state;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

}
