package com.limmy.fragrance.fragrances.Fragrance;

import java.util.Set;

public record ScentInfromationDTO(int id, String season, String timeOfDay, String longevity, String sillage,
                                  Set<Note> topNotes, Set<Note> middleNotes, Set<Note> baseNotes) {
}
