package com.limmy.fragranceApp.Fragrance;

import com.limmy.fragranceApp.Fragrance.Accord.Accord;
import com.limmy.fragranceApp.Fragrance.ScentInformation.CreateScentInformationDTO;
import com.limmy.fragranceApp.Fragrance.brand.BrandDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

public record CreateFragranceDTO(
        @NotBlank String name,
        @NotNull BrandDTO brand,
        String perfumer,
        @NotNull Concentration concentration,
        LocalDate releaseDate,
        boolean isRefillable,
        FragranceType nicheVsDesigner,
        String description,
        String pictures,
        CreateScentInformationDTO scentInformation,
        Set<Accord> accords) {
}
