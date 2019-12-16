<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/entity/Specialty.java
package org.regeneration.rest.restless.entity;
=======
package org.regeneration.efka.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/entity/Specialty.java

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Specialty {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "specialty", nullable = false, length = 50)
    private String specialty;

    @JsonIgnore
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

<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/entity/Specialty.java


=======
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/entity/Specialty.java
}
