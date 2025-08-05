package com.limmy.fragranceApp.Fragrance.Accord;


import com.limmy.fragranceApp.Fragrance.Mappers.AccordMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccordService {

    private final AccordRepository accordRepository;

    public AccordService(AccordRepository accordRepository) {
        this.accordRepository = accordRepository;
    }

    public List<AccordDTO> getAll() {
        return accordRepository.findAll()
                .stream()
                .map(AccordMapper::toAccordDTO)
                .toList();
    }
}
