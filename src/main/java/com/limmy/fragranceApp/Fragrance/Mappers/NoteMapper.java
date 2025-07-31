package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.Note.Note;
import com.limmy.fragranceApp.Fragrance.Note.NoteDTO;

public class NoteMapper {
    public static NoteDTO toNoteDto(Note note) {
        return new NoteDTO(
                note.getId(),
                note.getName()
        );
    }
}
