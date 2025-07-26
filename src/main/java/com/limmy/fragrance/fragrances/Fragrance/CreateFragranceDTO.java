package com.limmy.fragrance.fragrances.Fragrance;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Set;

public record CreateFragranceDTO(
        @NotBlank String name,
        @NotBlank String brand,
        String perfumer,
        String concentration,
        LocalDate releaseDate,
        boolean isRefillable,
        FragranceType nicheVsDesigner,
        String description,
        String pictures,
        ScentInfromationDTO scentInformation,
        Set<Accord> accords) {
}
