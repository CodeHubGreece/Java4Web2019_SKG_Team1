package org.regeneration.sample.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Citizen {
    private int id;
    private int amka;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumner;
    private Collection<Appointment> appointmentsById;
    private User userById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AMKA", nullable = false)
    public int getAmka() {
        return amka;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }

    @Basic
    @Column(name = "first_name", nullable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone_numner", nullable = true, length = 11)
    public String getPhoneNumner() {
        return phoneNumner;
    }

    public void setPhoneNumner(String phoneNumner) {
        this.phoneNumner = phoneNumner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return id == citizen.id &&
                amka == citizen.amka &&
                Objects.equals(firstName, citizen.firstName) &&
                Objects.equals(lastName, citizen.lastName) &&
                Objects.equals(email, citizen.email) &&
                Objects.equals(phoneNumner, citizen.phoneNumner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amka, firstName, lastName, email, phoneNumner);
    }

    @OneToMany(mappedBy = "citizenByCitizenId")
    public Collection<Appointment> getAppointmentsById() {
        return appointmentsById;
    }

    public void setAppointmentsById(Collection<Appointment> appointmentsById) {
        this.appointmentsById = appointmentsById;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public User getUserById() {
        return userById;
    }

    public void setUserById(User userById) {
        this.userById = userById;
    }
}
