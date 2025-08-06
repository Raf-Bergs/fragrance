package com.limmy.fragranceApp.Fragrance.ScentInformation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scentInformation")
public class ScentInformationController {
    private final ScentInformationService scentInformationService;

    public ScentInformationController(ScentInformationService scentInformationService) {
        this.scentInformationService = scentInformationService;
    }
}
