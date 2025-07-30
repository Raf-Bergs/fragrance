package com.limmy.fragranceApp.Fragrance;

import com.limmy.fragranceApp.Fragrance.Accord.Accord;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInfromationDTO;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Set;

public record CreateFragranceDTO(
        @NotBlank String name,
        @NotBlank String brand,
        String perfumer,
        @NotBlank String concentration,
        LocalDate releaseDate,
        boolean isRefillable,
        FragranceType nicheVsDesigner,
        String description,
        String pictures,
        ScentInfromationDTO scentInformation,
        Set<Accord> accords) {
}
