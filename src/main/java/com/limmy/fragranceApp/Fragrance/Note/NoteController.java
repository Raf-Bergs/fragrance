package com.limmy.fragranceApp.Fragrance.Note;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping
    public List<NoteDTO> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public NoteDTO getNoteById(@PathVariable int id) {
        return noteService.getNoteById(id);
    }

    @PostMapping
    public int createNote(@Valid @RequestBody CreateNoteDTO createNoteDTO) {
        return noteService.createNote(createNoteDTO);
    }
}
