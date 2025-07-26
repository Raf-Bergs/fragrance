package com.limmy.fragrance.fragrances.Fragrance;

public class FragranceMapper {
    static FragranceDTO toDto(Fragrance fragrance) {
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
