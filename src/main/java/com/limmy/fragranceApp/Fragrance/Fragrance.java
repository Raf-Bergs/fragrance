package com.limmy.fragranceApp.Fragrance;

import com.limmy.fragranceApp.Fragrance.Accord.Accord;
import com.limmy.fragranceApp.Fragrance.ScentInformation.ScentInformation;
import com.limmy.fragranceApp.Fragrance.brand.Brand;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fragrance")
public class Fragrance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    private String perfumer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Concentration concentration;

    private LocalDate releaseDate;
    private boolean isRefillable;

    @Enumerated(EnumType.STRING)
    private FragranceType nicheVsDesigner;

    private String description;
    private String pictures;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "scentinformation_id")
    private ScentInformation scentInformation;

    @ManyToMany
    @JoinTable(name = "fragrance_accord",
            joinColumns = @JoinColumn(name = "fragrance_id"),
            inverseJoinColumns = @JoinColumn(name = "accord_id"))
    private Set<Accord> accords = new HashSet<>();

    public Fragrance() {
    }

    public Fragrance(String name, Brand brand, String perfumer, Concentration concentration, LocalDate releaseDate, boolean isRefillable, FragranceType nicheVsDesigner, String description, String pictures, ScentInformation scentInformation, Set<Accord> accords) {
        this.name = name;
        this.brand = brand;
        this.perfumer = perfumer;
        this.concentration = concentration;
        this.releaseDate = releaseDate;
        this.isRefillable = isRefillable;
        this.nicheVsDesigner = nicheVsDesigner;
        this.description = description;
        this.pictures = pictures;
        this.scentInformation = scentInformation;
        this.accords = accords;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getPerfumer() {
        return perfumer;
    }

    public Concentration getConcentration() {
        return concentration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public boolean isRefillable() {
        return isRefillable;
    }

    public FragranceType getNicheVsDesigner() {
        return nicheVsDesigner;
    }

    public String getDescription() {
        return description;
    }

    public String getPictures() {
        return pictures;
    }

    public ScentInformation getScentInformation() {
        return scentInformation;
    }

    public Set<Accord> getAccords() {
        return accords;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fragrance)) return false;
        Fragrance fragrance = (Fragrance) o;
        return id == fragrance.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

}
