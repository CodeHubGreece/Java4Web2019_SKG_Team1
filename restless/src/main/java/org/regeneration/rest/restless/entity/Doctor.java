<<<<<<< Updated upstream:restless/src/main/java/org/regeneration/rest/restless/entity/Doctor.java
package org.regeneration.rest.restless.entity;
=======
package org.regeneration.efka.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> Stashed changes:restless/src/main/java/org/regeneration/efka/entity/Doctor.java

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Doctor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    private int userId;

    @Column(name = "first_name", length = 32)
    private String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @OneToMany(mappedBy = "doctor")
    private Collection<Appointment> appointments;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "specialty_id", nullable = false, insertable = false, updatable = false)
    private int specialityId;

    @ManyToOne
    @JoinColumn(name = "specialty_id", referencedColumnName = "id", nullable = false)
    private Specialty specialty;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, Specialty specialty) {
        this.userId=user.getId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSpecialtyId() {
        return specialityId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialityId = specialityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id &&
                userId == doctor.userId &&
                Objects.equals(firstName, doctor.firstName) &&
                Objects.equals(lastName, doctor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, firstName, lastName);
    }

    public Collection<Appointment> getAppointmentsById() {
        return appointments;
    }

    public void setAppointmentsById(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty.getDoctors().remove(this);
        this.specialty = specialty;
        this.specialty.getDoctors().add(this);
    }
}
