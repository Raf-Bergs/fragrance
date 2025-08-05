package com.limmy.fragranceApp.Fragrance.Accord;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
