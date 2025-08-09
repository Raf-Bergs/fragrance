package com.limmy.fragranceApp.Fragrance.brand;

import jakarta.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    private String country;

    private String website;

    private Integer yearFounded;

    private Boolean isNiche;

    private String description;

    private String logoUrl;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
    }

    public Brand(String name, String country, String website, Integer yearFounded, Boolean isNiche, String description, String logoUrl) {
        this.name = name;
        this.country = country;
        this.website = website;
        this.yearFounded = yearFounded;
        this.isNiche = isNiche;
        this.description = description;
        this.logoUrl = logoUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getWebsite() {
        return website;
    }

    public Integer getYearFounded() {
        return yearFounded;
    }

    public Boolean getNiche() {
        return isNiche;
    }

    public String getDescription() {
        return description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brand)) return false;
        Brand brand = (Brand) o;
        return id == brand.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
