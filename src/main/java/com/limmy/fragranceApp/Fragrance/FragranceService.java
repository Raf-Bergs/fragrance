package com.limmy.fragranceApp.Fragrance;

import com.limmy.fragranceApp.Fragrance.Mappers.FragranceMapper;
import com.limmy.fragranceApp.Fragrance.Mappers.ScentInformationMapper;
import com.limmy.fragranceApp.Fragrance.Note.NoteRepository;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInformation;
import com.limmy.fragranceApp.Fragrance.brand.Brand;
import com.limmy.fragranceApp.Fragrance.brand.BrandRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FragranceService {

    private final FragranceRepository fragranceRepository;
    private final BrandRepository brandRepository;
    private final NoteRepository noteRepository;

    public FragranceService(FragranceRepository fragranceRepository, BrandRepository brandRepository, NoteRepository noteRepository) {
        this.fragranceRepository = fragranceRepository;
        this.brandRepository = brandRepository;
        this.noteRepository = noteRepository;
    }

    List<FragranceDTO> findAll() {
        return fragranceRepository.findAll()
                .stream()
                .map(FragranceMapper::toFragranceDto)
                .toList();
    }

    public Optional<FragranceDTO> getFragranceById(int id) {
        return fragranceRepository.findById(id)
                .map(FragranceMapper::toFragranceDto);
    }

    @Transactional
    int create(CreateFragranceDTO createFragranceDTO) {

        Brand brand = brandRepository.findByName(createFragranceDTO.brand().name())
                .orElseGet(() -> {
                    Brand newBrand = new Brand(createFragranceDTO.brand().name());
                    return brandRepository.save(newBrand);
                });

        ScentInformation scentInformation = ScentInformationMapper.toScentInformationEntity(createFragranceDTO.scentInformation(), noteRepository);
        Fragrance newFragrance = new Fragrance(createFragranceDTO.name(),
                brand,
                createFragranceDTO.perfumer(),
                createFragranceDTO.concentration(),
                createFragranceDTO.releaseDate(),
                createFragranceDTO.isRefillable(),
                createFragranceDTO.nicheVsDesigner(),
                createFragranceDTO.description(),
                createFragranceDTO.pictures(),
                scentInformation,
                createFragranceDTO.accords());

        fragranceRepository.save(newFragrance);
        return newFragrance.getId();
    }
}
