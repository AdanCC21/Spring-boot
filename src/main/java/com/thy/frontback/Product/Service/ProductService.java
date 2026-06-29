package com.thy.frontback.Product.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thy.frontback.Exceptions.E_400.*;
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

    public List<Product> getAll() {
        List<Product> products = this.repo.findAll();
        return products;
    }

    public Product getById(Long id) {
        return this.repo.findById(id)
                .orElseThrow(() -> new NotFoundExc("El producto con el id " + id + " No fue encontrado."));
    }

    public Product create(CreateProductDTO dto) {
        if (dto == null) {
            throw new BadRequest("No se especifico el objeto a actualizar");
        }

        Product toCreate = new Product();

        toCreate.setTitle(dto.getTitle());
        toCreate.setBrand(dto.getBrand());
        toCreate.setPrice(dto.getPrice());

        if (!dto.getImage().isEmpty()) {
            toCreate.setImage(dto.getImage());
        }

        return this.repo.save(toCreate);
    }

    public Product update(Long id, UpdateProductDTO dto) {
        if (dto == null || id == null || id <= 0) {
            throw new BadRequest("No se enviaron todos los atributos necesarios. Id = " + id + " DTO = " + dto);
        }

        Product toUpdate = this.repo.findById(id)
                .orElseThrow(() -> new NotFoundExc("El producto con el id " + id + " no fue encontrado"));

        if (dto.getTitle() != null && !dto.getTitle().isEmpty()) {
            toUpdate.setTitle(dto.getTitle());
        }

        if (dto.getPrice() != null) {
            toUpdate.setPrice(dto.getPrice());
        }

        if (dto.getImage() != null && !dto.getImage().isEmpty()) {
            toUpdate.setImage(dto.getImage());
        }

        return this.repo.save(toUpdate);
    }

    public Boolean delete(Long id) {
        if (id == null || id < 0) {
            throw new BadRequest("El id no fue especificado o no es valido");
        }

        this.getById(id);
        repo.deleteById(id);
        return true;
    }
}
