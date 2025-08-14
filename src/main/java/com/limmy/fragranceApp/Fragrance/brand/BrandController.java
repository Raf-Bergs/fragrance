package com.limmy.fragranceApp.Fragrance.brand;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public BrandDTO getBrandById(@PathVariable int id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public int createBrand(@RequestBody @Valid CreateBrandDTO createBrandDTO) {
        return brandService.createBrand(createBrandDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBrandById(@PathVariable int id) {
        brandService.deleteBrandById(id);
    }
}
