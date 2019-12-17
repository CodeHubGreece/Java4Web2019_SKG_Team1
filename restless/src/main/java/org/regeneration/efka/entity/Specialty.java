package org.regeneration.efka.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Specialty {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "specialty", nullable = false, length = 50)
    private String specialty;

    /*@OneToMany(mappedBy = "specialty", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Doctor> doctors;

    public Specialty(String specialty) {
        this.specialty = specialty;
        doctors = new ArrayList<>();
    }*/

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
