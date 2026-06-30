package com.thy.frontback.Brand.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thy.frontback.Brand.Entities.Brand;
import com.thy.frontback.Brand.Entities.DTO.CreateBrandDTO;
import com.thy.frontback.Brand.Repo.BrandRepo;
import com.thy.frontback.Exceptions.E_400.BadRequest;
import com.thy.frontback.Exceptions.E_400.NotFoundExc;

@Service
public class BrandService {
    private final BrandRepo repo;

    public BrandService(BrandRepo repo) {
        this.repo = repo;
    }

    public List<Brand> getAll() {
        return repo.findAll();
    }

    public Brand getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundExc("La marca con el id " + id + " No fue encontrada"));
    }

    public boolean existsByName(String name) {
        return repo.existsByName(name);
    }

    public Brand create(CreateBrandDTO dto) {
        if (dto == null) {
            throw new BadRequest("El Dto no fue especificado o no es valido");
        }

        Brand toCreate = new Brand(dto.getName(), dto.getLocation(), dto.getCreated());
        if (dto.getProducts() != null && dto.getProducts().size() > 0) {
            System.out.println(dto.getProducts());
            
            toCreate.setProducts(dto.getProducts());
        }

        return repo.save(toCreate);
    }

    public boolean delete(Long id) {
        if (id == null || id <= 0) {
            throw new BadRequest("El id no es valido");
        }
        repo.findById(id);
        repo.deleteById(id);
        return true;
    }
}
