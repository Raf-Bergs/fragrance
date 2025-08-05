package com.limmy.fragranceApp.Fragrance;

import com.limmy.fragranceApp.Fragrance.Accord.Accord;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInformationDTO;
import com.limmy.fragranceApp.Fragrance.brand.BrandDTO;

import java.time.LocalDate;
import java.util.Set;

public record FragranceDTO(int id,
                           String name,
                           BrandDTO brand,
                           String perfumer,
                           Concentration concentration,
                           LocalDate releaseDate,
                           boolean isRefillable,
                           FragranceType nicheVsDesigner,
                           String description,
                           String pictures,
                           ScentInformationDTO scentInformation,
                           Set<Accord> accords) {
}
