package com.thy.frontback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.thy.frontback.Brand.Entities.DTO.CreateBrandDTO;
import com.thy.frontback.Brand.Service.BrandService;
import com.thy.frontback.Location.Entities.Location;

@Component
public class DataInitializer implements CommandLineRunner {
    private BrandService brandService;

    public DataInitializer(BrandService service) {
        this.brandService = service;
    }

    @Override
    public void run(String... arg) throws Exception {
        CreateBrandDTO brandBase = new CreateBrandDTO("Apple", new Location("USA", "San Diego"));
        CreateBrandDTO nike = new CreateBrandDTO("Nike", new Location("USA", "New York"));
        CreateBrandDTO addidas = new CreateBrandDTO("Addidas", new Location("USA", "Arizona"));
        CreateBrandDTO addidas2 = new CreateBrandDTO("Addidas", new Location("USA", "Arizona"));

        List<CreateBrandDTO> brands = new ArrayList<>();
        brands.add(nike);
        brands.add(addidas);
        brands.add(brandBase);
        brands.add(addidas2);

        for (CreateBrandDTO brand : brands) {
            if (!brandService.existsByName(brand.getName())) {
                System.out.println("Brand creada" + brand);
                brandService.create(brand);
            }
        }
    }
}
