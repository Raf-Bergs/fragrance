package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.Note.Note;
import com.limmy.fragranceApp.Fragrance.Note.NoteDTO;

import static com.limmy.fragranceApp.Fragrance.util.NameNormalizer.normalize;

public class NoteMapper {
    public static NoteDTO toNoteDto(Note note) {
        return new NoteDTO(
                note.getId(),
                normalize(note.getName())
        );
    }
}
