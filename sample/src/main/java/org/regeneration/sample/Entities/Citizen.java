package org.regeneration.sample.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Citizen {
    private Long id;
    private int amka;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Collection<Appointment> appointmentsById;
    private User userById;

    public Citizen(){

    }

    public Citizen(int amka, String firstName, String lastName, String email, String phoneNumber){
        this.amka = amka;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    @Column(name = "first_name", nullable = true, length = 32)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 32)
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
    @Column(name = "phone_number", nullable = true, length = 11)
    public String getPhoneNumner() {
        return phoneNumber;
    }

    public void setPhoneNumner(String phoneNumner) {
        this.phoneNumber = phoneNumner;
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
                Objects.equals(phoneNumber, citizen.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amka, firstName, lastName, email, phoneNumber);
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
