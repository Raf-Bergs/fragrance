package com.limmy.fragrance.fragrances.Fragrance;

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
