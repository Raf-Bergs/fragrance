package com.limmy.fragranceApp.Fragrance.Mappers;

import com.limmy.fragranceApp.Fragrance.Note.Note;
import com.limmy.fragranceApp.Fragrance.Note.NoteRepository;
import com.limmy.fragranceApp.Fragrance.ScentInformation.CreateScentInformationDTO;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInformation;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInformationDTO;
import com.limmy.fragranceApp.Fragrance.util.NameNormalizer;

import java.util.Set;
import java.util.stream.Collectors;

import static com.limmy.fragranceApp.Fragrance.util.NameNormalizer.normalize;

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

    public static ScentInformation toScentInformationEntity(CreateScentInformationDTO createScentInformationDTO, NoteRepository noteRepository) {

        Set<Note> topNotes = resolveNotesByName(createScentInformationDTO.topNoteNames(), noteRepository);
        Set<Note> middleNotes = resolveNotesByName(createScentInformationDTO.middleNoteNames(), noteRepository);
        Set<Note> baseNotes = resolveNotesByName(createScentInformationDTO.baseNoteNames(), noteRepository);

        return new ScentInformation(
                normalize(createScentInformationDTO.longevity()),
                normalize(createScentInformationDTO.timeOfDay()),
                normalize(createScentInformationDTO.season()),
                normalize(createScentInformationDTO.sillage()),
                topNotes,
                middleNotes,
                baseNotes
        );
    }

    private static Set<Note> resolveNotesByName(Set<String> noteNames, NoteRepository noteRepository) {
        if (noteNames == null) return Set.of();

        return noteNames.stream()
                .map(NameNormalizer::normalize)
                .map(name -> noteRepository.findByNameIgnoreCase(name)
                        .orElseGet(() -> noteRepository.save(new Note(normalize(name))))
                )
                .collect(Collectors.toSet());
    }
}
