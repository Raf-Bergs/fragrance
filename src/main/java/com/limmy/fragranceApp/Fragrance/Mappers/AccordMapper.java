package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.Accord.Accord;
import com.limmy.fragranceApp.Fragrance.Accord.AccordDTO;

public class AccordMapper {
    public static AccordDTO toAccordDTO(Accord accord) {
        return new AccordDTO(
                accord.getId(),
                accord.getName()
        );
    }
}
