package com.limmy.fragranceApp.Fragrance.brand;

public class BrandAlreadyExistsException extends RuntimeException {
    public BrandAlreadyExistsException() {
        super("This Brand already exists.");
    }
}
