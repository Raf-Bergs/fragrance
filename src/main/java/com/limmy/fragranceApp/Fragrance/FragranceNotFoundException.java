package com.limmy.fragranceApp.Fragrance;

public class FragranceNotFoundException extends RuntimeException {
    public FragranceNotFoundException() {
        super("no fragrance was found.");
    }
}
