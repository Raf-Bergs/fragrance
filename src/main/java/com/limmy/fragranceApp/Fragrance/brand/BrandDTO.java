package com.limmy.fragranceApp.Fragrance.brand;

public record BrandDTO(
        int id,
        String name,
        String country,
        String website,
        Integer yearFounded,
        Boolean isNiche,
        String description,
        String logoUrl
) {
}
