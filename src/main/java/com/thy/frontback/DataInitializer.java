package com.thy.frontback;

import java.time.LocalDate;
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
        LocalDate hoy = LocalDate.now();
        CreateBrandDTO brandBase = new CreateBrandDTO("Apple", new Location("USA", "San Diego"), hoy);
        CreateBrandDTO nike = new CreateBrandDTO("Nike", new Location("USA", "New York"), hoy);
        CreateBrandDTO addidas = new CreateBrandDTO("Addidas", new Location("USA", "Arizona"), hoy);
        CreateBrandDTO addidas2 = new CreateBrandDTO("Razer", new Location("USA", "Arizona"), hoy);
        CreateBrandDTO logitech = new CreateBrandDTO("Logitech", new Location("USA", "Arizona"), hoy);

        List<CreateBrandDTO> brands = new ArrayList<>();
        brands.add(nike);
        brands.add(addidas);
        brands.add(brandBase);
        brands.add(addidas2);
        brands.add(logitech);

        for (CreateBrandDTO brand : brands) {
            if (!brandService.existsByName(brand.getName())) {
                System.out.println("Brand creada" + brand);
                brandService.create(brand);
            }
        }
    }
}
