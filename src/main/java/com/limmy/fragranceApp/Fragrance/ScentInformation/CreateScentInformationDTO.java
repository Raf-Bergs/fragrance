package com.limmy.fragranceApp.Fragrance.ScentInformation;

import java.util.Set;

public record CreateScentInformationDTO(
        String season,
        String timeOfDay,
        String longevity,
        String sillage,
        Set<Integer> topNoteIds,
        Set<Integer> middleNoteIds,
        Set<Integer> baseNoteIds
) {
}

