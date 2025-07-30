package com.limmy.fragranceApp.Fragrance.ScentInformation;

public class ScentInformationMapper {

    public static ScentInfromationDTO toDto(ScentInformation scentInformation) {
        return new ScentInfromationDTO(
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
}
