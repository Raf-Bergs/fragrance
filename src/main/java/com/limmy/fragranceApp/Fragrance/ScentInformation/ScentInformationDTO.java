package com.limmy.fragranceApp.Fragrance.ScentInformation;

import com.limmy.fragranceApp.Fragrance.Note.Note;

import java.util.Set;

public record ScentInformationDTO(int id, String season, String timeOfDay, String longevity, String sillage,
                                  Set<Note> topNotes, Set<Note> middleNotes, Set<Note> baseNotes) {
}
