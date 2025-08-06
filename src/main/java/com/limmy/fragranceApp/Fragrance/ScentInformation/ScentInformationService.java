package com.limmy.fragranceApp.Fragrance.ScentInformation;

import org.springframework.stereotype.Service;

@Service
public class ScentInformationService {
    private final ScentInformationRepository scentInformationRepository;

    public ScentInformationService(ScentInformationRepository scentInformationRepository) {
        this.scentInformationRepository = scentInformationRepository;
    }
}
