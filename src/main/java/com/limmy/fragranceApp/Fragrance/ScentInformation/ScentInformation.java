package com.limmy.fragranceApp.Fragrance.ScentInformation;

import com.limmy.fragranceApp.Fragrance.Fragrance;
import com.limmy.fragranceApp.Fragrance.Note.Note;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "scentinformation")
public class ScentInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String season;
    private String timeOfDay;
    private String longevity;
    private String sillage;

    @OneToOne(mappedBy = "scentInformation")
    private Fragrance fragrance;

    @ManyToMany
    @JoinTable(name = "scentinformation_topnote",
            joinColumns = @JoinColumn(name = "scentinformation_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id"))
    private Set<Note> topNotes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "scentinformation_middlenote",
            joinColumns = @JoinColumn(name = "scentinformation_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id"))
    private Set<Note> middleNotes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "scentinformation_basenote",
            joinColumns = @JoinColumn(name = "scentinformation_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id"))
    private Set<Note> baseNotes = new HashSet<>();


    public ScentInformation(String season, String timeOfDay, String longevity, String sillage, Fragrance fragrance, Set<Note> topNotes, Set<Note> middleNotes, Set<Note> baseNotes) {
        this.season = season;
        this.timeOfDay = timeOfDay;
        this.longevity = longevity;
        this.sillage = sillage;
        this.fragrance = fragrance;
        this.topNotes = topNotes;
        this.middleNotes = middleNotes;
        this.baseNotes = baseNotes;
    }

    public ScentInformation() {
    }

    public ScentInformation(String season, String timeOfDay, String longevity, String sillage, Set<Note> topNotes, Set<Note> middleNotes, Set<Note> baseNotes) {
        this.season = season;
        this.timeOfDay = timeOfDay;
        this.longevity = longevity;
        this.sillage = sillage;
        this.topNotes = topNotes;
        this.middleNotes = middleNotes;
        this.baseNotes = baseNotes;
    }

    public int getId() {
        return id;
    }

    public String getSeason() {
        return season;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public String getLongevity() {
        return longevity;
    }

    public String getSillage() {
        return sillage;
    }

    public Fragrance getFragrance() {
        return fragrance;
    }

    public Set<Note> getTopNotes() {
        return topNotes;
    }

    public Set<Note> getMiddleNotes() {
        return middleNotes;
    }

    public Set<Note> getBaseNotes() {
        return baseNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScentInformation)) return false;
        ScentInformation that = (ScentInformation) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

}
