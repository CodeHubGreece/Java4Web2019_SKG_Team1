package org.regeneration.efka.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    private int userId;

    @Column(name = "amka", nullable = false, unique = true)
    private Long amka;

    @Column(name = "first_name", length = 32)
    private String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @Email
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @OneToMany(mappedBy = "citizen", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Appointment> appointments;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private User user;

    public Citizen(Long amka, String firstName, String lastName, String email, String phoneNumber) {
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
