package org.regeneration.rest.restless.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Appointment {
    @Id
    @Column(name = "id", nullable = false)
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
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

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizenByCitizenId(Citizen citizen) {
        this.citizen = citizen;
    }

    public Doctor getDoctorByDoctorId() {
        return doctor;
    }

    public void setDoctorByDoctorId(Doctor doctor) {
        this.doctor = doctor;
    }
}
