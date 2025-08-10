package com.limmy.fragranceApp.Fragrance.Note;

import jakarta.validation.constraints.NotBlank;

public record CreateNoteDTO(@NotBlank String name) {
}
