package com.thy.frontback.Product.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thy.frontback.Product.Entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByTitle(String title);

    boolean existsByTitle(String title);
}
