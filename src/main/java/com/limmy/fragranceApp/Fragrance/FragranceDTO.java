package com.limmy.fragranceApp.Fragrance;

import com.limmy.fragranceApp.Fragrance.Accord.Accord;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInfromationDTO;

import java.time.LocalDate;
import java.util.Set;

public record FragranceDTO(int id,
                           String name,
                           String brand,
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
