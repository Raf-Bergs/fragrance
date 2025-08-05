package com.limmy.fragranceApp.Fragrance.brand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);

    Optional<Brand> findByName(String name);
}
