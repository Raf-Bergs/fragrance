package com.limmy.fragranceApp.Fragrance;

import com.limmy.fragranceApp.Fragrance.Accord.Accord;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInfromationDTO;
import com.limmy.fragranceApp.Fragrance.brand.BrandDTO;

import java.time.LocalDate;
import java.util.Set;

public record FragranceDTO(int id,
                           String name,
                           BrandDTO brand,
                           String perfumer,
                           String concentration,
                           LocalDate releaseDate,
                           boolean isRefillable,
                           FragranceType nicheVsDesigner,
                           String description,
                           String pictures,
                           ScentInfromationDTO scentInformation,
                           Set<Accord> accords) {
}
