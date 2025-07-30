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

    @Column(length = 2000)
    private String description;

    private String logoUrl;

    public Brand() {
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
