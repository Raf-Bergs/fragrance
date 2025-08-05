package com.limmy.fragranceApp.Fragrance;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Integer> createFragrance(@RequestBody @Valid CreateFragranceDTO createFragranceDTO) {
        int newFragranceId = fragranceService.create(createFragranceDTO);
        return ResponseEntity.ok(newFragranceId);
    }
}
