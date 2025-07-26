package com.limmy.fragrance.fragrances.Fragrance;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("fragrance")
public class FragranceController {

    private final FragranceService fragranceService;

    public FragranceController(FragranceService fragranceService) {
        this.fragranceService = fragranceService;
    }

    @GetMapping("/{id}")
    Optional<FragranceDTO> getFragranceById(@PathVariable int id) {
        return fragranceService.getFragranceById(id);
    }

    @GetMapping
    List<FragranceDTO> findAllFragrances() {
        return fragranceService.findAll();
    }
}
