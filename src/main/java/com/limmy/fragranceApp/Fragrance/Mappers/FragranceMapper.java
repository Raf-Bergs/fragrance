package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.Fragrance;
import com.limmy.fragranceApp.Fragrance.FragranceDTO;

public class FragranceMapper {
    public static FragranceDTO toFragranceDto(Fragrance fragrance) {
        return new FragranceDTO(
                fragrance.getId(),
                fragrance.getName(),
                BrandMapper.toBrandDTO(fragrance.getBrand()),
                fragrance.getPerfumer(),
                fragrance.getConcentration(),
                fragrance.getReleaseDate(),
                fragrance.isRefillable(),
                fragrance.getNicheVsDesigner(),
                fragrance.getDescription(),
                fragrance.getPictures(),
                ScentInformationMapper.toDto(fragrance.getScentInformation()),
                fragrance.getAccords()
        );
    }
}
