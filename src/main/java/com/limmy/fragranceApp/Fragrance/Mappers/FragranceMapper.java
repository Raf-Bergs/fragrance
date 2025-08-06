package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.Fragrance;
import com.limmy.fragranceApp.Fragrance.FragranceDTO;

import static com.limmy.fragranceApp.Fragrance.util.NameNormalizer.normalize;

public class FragranceMapper {
    public static FragranceDTO toFragranceDto(Fragrance fragrance) {
        return new FragranceDTO(
                fragrance.getId(),
                normalize(fragrance.getName()),
                BrandMapper.toBrandDTO(fragrance.getBrand()),
                fragrance.getPerfumer(),
                fragrance.getConcentration(),
                fragrance.getReleaseDate(),
                fragrance.isRefillable(),
                fragrance.getNicheVsDesigner(),
                fragrance.getDescription(),
                fragrance.getPictures(),
                ScentInformationMapper.toScentInformationDTO(fragrance.getScentInformation()),
                fragrance.getAccords()
        );
    }
}
