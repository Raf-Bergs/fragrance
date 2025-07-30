package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.Fragrance;
import com.limmy.fragranceApp.Fragrance.FragranceDTO;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInformationMapper;

public class FragranceMapper {
    public static FragranceDTO toDto(Fragrance fragrance) {
        return new FragranceDTO(
                fragrance.getId(),
                fragrance.getName(),
                fragrance.getBrand(),
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
