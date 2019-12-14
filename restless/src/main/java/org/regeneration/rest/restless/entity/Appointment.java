package org.regeneration.rest.restless.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Appointment {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "citizen_id", nullable = false, insertable = false, updatable = false)
    private int citizenId;

    @Column(name = "doctor_id", nullable = false, insertable = false, updatable = false)
    private int doctorId;

    @Column(name = "datetime", nullable = false)
    private Timestamp datetime;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column(name = "notes", nullable = true, columnDefinition = "TEXT")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "citizen_id", referencedColumnName = "id", nullable = false)
    private Citizen citizen;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    private Doctor doctor;


    public Appointment(int id, int citizenId, int doctorId, Timestamp datetime, String description, String notes) {
        this.id = id;
        this.citizenId = citizenId;
        this.doctorId = doctorId;
        this.datetime = datetime;
        this.description = description;
        this.notes = notes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id &&
                citizenId == that.citizenId &&
                doctorId == that.doctorId &&
                Objects.equals(datetime, that.datetime) &&
                Objects.equals(description, that.description) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, citizenId, doctorId, datetime, description, notes);
    }

}
