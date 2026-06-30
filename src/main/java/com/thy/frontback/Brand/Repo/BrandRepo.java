package com.thy.frontback.Brand.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thy.frontback.Brand.Entities.Brand;

public interface BrandRepo extends JpaRepository<Brand,Long>{
    boolean existsByName(String name);
}
