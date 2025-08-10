package com.limmy.fragranceApp.Fragrance.Note;

public class NoteAlreadyExistsException extends RuntimeException {
    public NoteAlreadyExistsException() {
        super("This note already exists.");
    }
}
