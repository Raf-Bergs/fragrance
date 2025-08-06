package com.limmy.fragranceApp.Fragrance.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NameNormalizer {
    public static String normalize(String input) {
        if (input == null || input.isBlank()) {
            return "";
        }

        return Arrays.stream(input.trim().toLowerCase().split("\\s+"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}
