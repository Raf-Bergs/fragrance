package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.brand.Brand;
import com.limmy.fragranceApp.Fragrance.brand.BrandDTO;

public class BrandMapper {
    public static BrandDTO toBrandDTO(Brand brand) {
        return new BrandDTO(
                brand.getId(),
                brand.getName(),
                brand.getCountry(),
                brand.getCountry(),
                brand.getYearFounded(),
                brand.getNiche(),
                brand.getWebsite(),
                brand.getLogoUrl()
        );
    }
}
