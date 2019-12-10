package org.regeneration.sample.Entities;

import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Specialty {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "specialty", nullable = false, length = 50)
    private String specialty;

    @OneToMany(mappedBy = "specialty")
    private Collection<Doctor> doctors;

    public Specialty() {
    }


    public Specialty(String specialty) {
        this.specialty=specialty;
        doctors = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Collection<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Collection<Doctor> doctors) {
        this.doctors = doctors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty1 = (Specialty) o;
        return id == specialty1.id &&
                Objects.equals(specialty, specialty1.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialty);
    }



}
