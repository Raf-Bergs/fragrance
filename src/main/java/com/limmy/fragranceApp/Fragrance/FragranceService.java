package com.limmy.fragranceApp.Fragrance;

import com.limmy.fragranceApp.Fragrance.Mappers.FragranceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FragranceService {

    private final FragranceRepository fragranceRepository;

    public FragranceService(FragranceRepository fragranceRepository) {
        this.fragranceRepository = fragranceRepository;
    }

    List<FragranceDTO> findAll() {
        return fragranceRepository.findAll()
                .stream()
                .map(FragranceMapper::toDto)
                .toList();
    }

    public Optional<FragranceDTO> getFragranceById(int id) {
        return fragranceRepository.findById(id)
                .map(FragranceMapper::toDto);
    }
}
