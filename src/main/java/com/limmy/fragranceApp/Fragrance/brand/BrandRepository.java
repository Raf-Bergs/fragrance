package com.limmy.fragranceApp.Fragrance.brand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);

    Brand findByName(String name);
}
