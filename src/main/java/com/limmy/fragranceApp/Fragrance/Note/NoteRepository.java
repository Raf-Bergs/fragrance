package com.limmy.fragranceApp.Fragrance.Note;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    Optional<Note> findByNameIgnoreCase(String name);
}
