package com.limmy.fragranceApp.Fragrance.brand;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException() {
        super("No brand was found.");
    }
}
