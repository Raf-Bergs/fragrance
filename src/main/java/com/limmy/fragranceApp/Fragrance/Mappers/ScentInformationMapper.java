package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.Note.Note;
import com.limmy.fragranceApp.Fragrance.Note.NoteRepository;
import com.limmy.fragranceApp.Fragrance.ScentInformation.CreateScentInformationDTO;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInformation;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInformationDTO;

import java.util.HashSet;
import java.util.Set;

public class ScentInformationMapper {

    public static ScentInformationDTO toScentInformationDTO(ScentInformation scentInformation) {
        return new ScentInformationDTO(
                scentInformation.getId(),
                scentInformation.getSeason(),
                scentInformation.getTimeOfDay(),
                scentInformation.getLongevity(),
                scentInformation.getSillage(),
                scentInformation.getTopNotes(),
                scentInformation.getMiddleNotes(),
                scentInformation.getBaseNotes()
        );
    }

    public static ScentInformation toScentInformationEntity(CreateScentInformationDTO scentInformationDTO, NoteRepository noteRepository) {

        Set<Note> topNotes = new HashSet<>(noteRepository.findAllById(scentInformationDTO.topNoteIds()));
        Set<Note> middleNotes = new HashSet<>(noteRepository.findAllById(scentInformationDTO.middleNoteIds()));
        Set<Note> baseNotes = new HashSet<>(noteRepository.findAllById(scentInformationDTO.baseNoteIds()));

        return new ScentInformation(
                scentInformationDTO.season(),
                scentInformationDTO.timeOfDay(),
                scentInformationDTO.longevity(),
                scentInformationDTO.sillage(),
                topNotes,
                middleNotes,
                baseNotes
        );
    }
}
