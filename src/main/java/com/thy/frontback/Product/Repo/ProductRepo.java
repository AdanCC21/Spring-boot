package com.thy.frontback.Product.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thy.frontback.Product.Entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
