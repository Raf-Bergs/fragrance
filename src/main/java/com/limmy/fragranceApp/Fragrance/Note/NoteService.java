package com.limmy.fragranceApp.Fragrance.Note;

import com.limmy.fragranceApp.Fragrance.Mappers.NoteMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.limmy.fragranceApp.Fragrance.util.NameNormalizer.normalize;

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

    public NoteDTO getNoteById(int id) throws NoteNotFoundException {
        return noteRepository.findById(id)
                .map(NoteMapper::toNoteDto)
                .orElseThrow(NoteNotFoundException::new);
    }

    public int createNote(CreateNoteDTO createNoteDTO) {
        if (noteRepository.findByNameIgnoreCase(createNoteDTO.name()).isPresent()) {
            throw new NoteAlreadyExistsException();
        }

        Note newNote = new Note(normalize(createNoteDTO.name()));
        noteRepository.save(newNote);
        return newNote.getId();
    }

    public void deleteNoteById(int id) {
        noteRepository.deleteById(id);
    }
}
