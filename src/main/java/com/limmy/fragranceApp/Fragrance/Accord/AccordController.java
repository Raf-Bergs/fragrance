package com.limmy.fragranceApp.Fragrance.Accord;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Accords")
public class AccordController {
    private final AccordService accordService;

    public AccordController(AccordService accordService) {
        this.accordService = accordService;
    }


    @GetMapping
    public List<AccordDTO> getAll() {
        return accordService.getAll();
    }

    @PostMapping
    public int createAccord(@RequestBody @Valid CreateAccordDTO createAccordDTO) {
        return accordService.createAccord(createAccordDTO);
    }

    @GetMapping("/{id}")
    public AccordDTO getAccordById(@PathVariable int id) {
        return accordService.getAccordById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccordById(@PathVariable int id) {
        accordService.deleteAccordById(id);
    }
}
