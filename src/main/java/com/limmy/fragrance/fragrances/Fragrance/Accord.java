package com.limmy.fragrance.fragrances.Fragrance;

import jakarta.persistence.*;

@Entity
@Table(name = "accord")
public class Accord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String name;

    public Accord() {
    }

    public Accord(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accord)) return false;
        Accord accord = (Accord) o;
        return id == accord.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

}
