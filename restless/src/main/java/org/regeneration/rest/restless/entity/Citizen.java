package org.regeneration.rest.restless.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    private int userId;

    @Column(name = "amka", nullable = false, unique = true)
    private int amka;

    @Column(name = "first_name", length = 32)
    private String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @OneToMany(mappedBy = "citizen")
    private Collection<Appointment> appointments;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Citizen(User user, int amka, String firstName, String lastName, String email, String phoneNumber) {
        this.user = user;
        this.amka = amka;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return id == citizen.id &&
                userId == citizen.userId &&
                amka == citizen.amka &&
                Objects.equals(firstName, citizen.firstName) &&
                Objects.equals(lastName, citizen.lastName) &&
                Objects.equals(email, citizen.email) &&
                Objects.equals(phoneNumber, citizen.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, amka, firstName, lastName, email, phoneNumber);
    }

}