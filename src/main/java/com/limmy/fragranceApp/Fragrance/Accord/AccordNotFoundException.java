package com.limmy.fragranceApp.Fragrance.Accord;

public class AccordNotFoundException extends RuntimeException {
    public AccordNotFoundException() {
        super("Accord couldn't be found");
    }
}
