package com.limmy.fragranceApp.Fragrance.brand;

import jakarta.validation.constraints.NotBlank;

public record CreateBrandDTO(
        @NotBlank String name,
        String country,
        String website,
        Integer yearFounded,
        Boolean isNiche,
        String description,
        String logoUrl
) {
}
