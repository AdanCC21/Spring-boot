package com.thy.frontback.Product.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.thy.frontback.Product.Entities.Product;
import com.thy.frontback.Product.Entities.DTO.CreateProductDTO;
import com.thy.frontback.Product.Entities.DTO.UpdateProductDTO;
import com.thy.frontback.Product.Repo.ProductRepo;

@Service
public class ProductService {
    private final ProductRepo repo;

    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = this.repo.findAll();
        return ResponseEntity.ok(products);
    }

    public ResponseEntity<Product> getById(Long id) {
        Product prod = this.repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return ResponseEntity.ok(prod);
    }

    public ResponseEntity<Product> create(CreateProductDTO dto) {
        if (dto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Product toCreate = new Product();
        toCreate.setTitle(dto.getTitle());
        toCreate.setBrand(dto.getBrand());
        toCreate.setPrice(dto.getPrice());
        if (!dto.getImage().isEmpty()) {
            toCreate.setImage(dto.getImage());
        }

        Product created = this.repo.save(toCreate);

        return ResponseEntity.ok(created);
    }

    public ResponseEntity<Product> update(UpdateProductDTO dto) {
        if (dto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Product toUpdate = new Product();
        toUpdate.setTitle(dto.getTitle());
        toUpdate.setPrice(dto.getPrice());
        if (!dto.getImage().isEmpty()) {
            toUpdate.setImage(dto.getImage());
        }

        Product updated = this.repo.save(toUpdate);

        return ResponseEntity.ok(updated);
    }

    public ResponseEntity<Boolean> delete(Long id) {
        if (id == null || id < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        ResponseEntity<Product> finded = this.getById(id);

        if(finded == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        this.repo.deleteById(id);
        return ResponseEntity.ok(true);
    }
}
