package com.limmy.fragranceApp.Fragrance.Accord;

import jakarta.validation.constraints.NotBlank;

public record CreateAccordDTO(@NotBlank String name) {
}
