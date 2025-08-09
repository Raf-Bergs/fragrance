package com.limmy.fragranceApp.Fragrance.Accord;

public class AccordAlreadyExistsException extends RuntimeException {
    public AccordAlreadyExistsException() {
        super("Accord with that name already exists.");
    }
}
