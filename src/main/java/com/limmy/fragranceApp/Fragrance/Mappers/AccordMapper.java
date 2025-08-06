package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.Accord.Accord;
import com.limmy.fragranceApp.Fragrance.Accord.AccordDTO;

import static com.limmy.fragranceApp.Fragrance.util.NameNormalizer.normalize;

public class AccordMapper {
    public static AccordDTO toAccordDTO(Accord accord) {
        return new AccordDTO(
                accord.getId(),
                normalize(accord.getName())
        );
    }
}
