package com.limmy.fragranceApp.Fragrance.ScentInformation;

import java.util.Set;

public record CreateScentInformationDTO(
        String season,
        String timeOfDay,
        String longevity,
        String sillage,
        Set<String> topNoteNames,
        Set<String> middleNoteNames,
        Set<String> baseNoteNames
) {
}

