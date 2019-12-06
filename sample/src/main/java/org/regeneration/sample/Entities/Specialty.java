package org.regeneration.sample.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Specialty {
    private int id;
    private String specialty;
    private Collection<Doctor> doctorsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "specialty", nullable = false, length = 50)
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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

    @OneToMany(mappedBy = "specialtyBySpecialtyId")
    public Collection<Doctor> getDoctorsById() {
        return doctorsById;
    }

    public void setDoctorsById(Collection<Doctor> doctorsById) {
        this.doctorsById = doctorsById;
    }
}
