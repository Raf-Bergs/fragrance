package com.limmy.fragranceApp.Fragrance.Accord;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccordRepository extends JpaRepository<Accord, Integer> {
    Optional<Accord> findByNameIgnoreCase(String name);

    long countByName(String name);
}
