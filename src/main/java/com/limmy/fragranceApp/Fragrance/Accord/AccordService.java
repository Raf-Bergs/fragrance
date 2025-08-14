package com.limmy.fragranceApp.Fragrance.Accord;


import com.limmy.fragranceApp.Fragrance.Mappers.AccordMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.limmy.fragranceApp.Fragrance.util.NameNormalizer.normalize;

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

    public AccordDTO getAccordById(int id) throws AccordNotFoundException {
        return accordRepository.findById(id)
                .map(AccordMapper::toAccordDTO)
                .orElseThrow(AccordNotFoundException::new);
    }

    public int createAccord(CreateAccordDTO createAccordDTO) throws AccordAlreadyExistsException {
        if (accordRepository.countByName(createAccordDTO.name()) > 0)
            throw new AccordAlreadyExistsException();

        Accord newAccord = new Accord(normalize(createAccordDTO.name()));
        accordRepository.save(newAccord);
        return newAccord.getId();
    }

    public void deleteAccordById(int id) {
        accordRepository.deleteById(id);
    }


}
