package com.limmy.fragrance.fragrances.review;

import com.limmy.fragrance.fragrances.Fragrance.Fragrance;
import com.limmy.fragrance.fragrances.Fragrance.SampleOrBottle;
import jakarta.persistence.*;

@Entity
@Table(name = "personalreview")
public class PersonalReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rating;

    @Enumerated(EnumType.STRING)
    private SampleOrBottle sampleOrBottle;

    private String review;

    @OneToOne
    @JoinColumn(name = "fragrance_id", nullable = false, unique = true)
    private Fragrance fragrance;

    public PersonalReview() {
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public SampleOrBottle getSampleOrBottle() {
        return sampleOrBottle;
    }

    public String getReview() {
        return review;
    }

    public Fragrance getFragrance() {
        return fragrance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalReview)) return false;
        PersonalReview that = (PersonalReview) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

}
