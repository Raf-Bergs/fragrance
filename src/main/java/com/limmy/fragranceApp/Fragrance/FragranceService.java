package com.limmy.fragranceApp.Fragrance;

import com.limmy.fragranceApp.Fragrance.Accord.Accord;
import com.limmy.fragranceApp.Fragrance.Accord.AccordRepository;
import com.limmy.fragranceApp.Fragrance.Mappers.FragranceMapper;
import com.limmy.fragranceApp.Fragrance.Mappers.ScentInformationMapper;
import com.limmy.fragranceApp.Fragrance.Note.NoteRepository;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInformation;
import com.limmy.fragranceApp.Fragrance.brand.Brand;
import com.limmy.fragranceApp.Fragrance.brand.BrandRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.limmy.fragranceApp.Fragrance.util.NameNormalizer.normalize;

@Service
public class FragranceService {

    private final FragranceRepository fragranceRepository;
    private final BrandRepository brandRepository;
    private final NoteRepository noteRepository;
    private final AccordRepository accordRepository;

    public FragranceService(FragranceRepository fragranceRepository, BrandRepository brandRepository, NoteRepository noteRepository, AccordRepository accordRepository) {
        this.fragranceRepository = fragranceRepository;
        this.brandRepository = brandRepository;
        this.noteRepository = noteRepository;
        this.accordRepository = accordRepository;
    }

    List<FragranceDTO> findAll() {
        return fragranceRepository.findAll()
                .stream()
                .map(FragranceMapper::toFragranceDto)
                .toList();
    }

    long getCount() {
        return fragranceRepository.count();
    }

    public FragranceDTO getFragranceById(int id) throws FragranceNotFoundException {
        return fragranceRepository.findById(id)
                .map(FragranceMapper::toFragranceDto)
                .orElseThrow(FragranceNotFoundException::new);
    }

    @Transactional
    int create(CreateFragranceDTO createFragranceDTO) {

        Brand brand = brandRepository.findByNameIgnoreCase(createFragranceDTO.brand().name())
                .orElseGet(() -> {
                    Brand newBrand = new Brand(createFragranceDTO.brand().name());
                    return brandRepository.save(newBrand);
                });
        Set<Accord> accords = createFragranceDTO.accordNames().stream()
                .map(name -> accordRepository.findByNameIgnoreCase(name)
                        .orElseGet(() -> accordRepository.save(new Accord(name)))
                )
                .collect(Collectors.toSet());

        ScentInformation scentInformation = ScentInformationMapper.toScentInformationEntity(createFragranceDTO.scentInformation(), noteRepository);
        Fragrance newFragrance = new Fragrance(
                normalize(createFragranceDTO.name()),
                brand,
                createFragranceDTO.perfumer(),
                createFragranceDTO.concentration(),
                createFragranceDTO.releaseDate(),
                createFragranceDTO.isRefillable(),
                createFragranceDTO.nicheVsDesigner(),
                createFragranceDTO.description(),
                createFragranceDTO.pictures(),
                scentInformation,
                accords);

        fragranceRepository.save(newFragrance);
        return newFragrance.getId();
    }

    public void deleteFragranceById(int id) {
        fragranceRepository.deleteById(id);
    }
}
