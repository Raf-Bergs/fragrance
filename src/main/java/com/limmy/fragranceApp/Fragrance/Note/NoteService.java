package com.limmy.fragranceApp.Fragrance.Note;

import com.limmy.fragranceApp.Fragrance.Mappers.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<NoteDTO> getAllNotes() {
        return noteRepository.findAll().stream()
                .map(NoteMapper::toNoteDto)
                .toList();
    }
}
