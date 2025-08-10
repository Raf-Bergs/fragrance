package com.limmy.fragranceApp.Fragrance.Note;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException() {
        super("No note found.");
    }
}
