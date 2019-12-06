package org.regeneration.sample.Entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Appointment {
    private int id;
    private int citizenId;
    private int doctorId;
    private Timestamp appointmentDatetime;
    private String description;
    private String notes;
    private Citizen citizenByCitizenId;
    private Doctor doctorByDoctorId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "citizen_id", nullable = false, insertable = false, updatable = false)
    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    @Basic
    @Column(name = "doctor_id", nullable = false, insertable = false, updatable = false)
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "appointment_datetime", nullable = false)
    public Timestamp getAppointmentDatetime() {
        return appointmentDatetime;
    }

    public void setAppointmentDatetime(Timestamp appointmentDatetime) {
        this.appointmentDatetime = appointmentDatetime;
    }

    @Basic
    @Column(name = "description", nullable = true)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "notes", nullable = true)
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
                Objects.equals(appointmentDatetime, that.appointmentDatetime) &&
                Objects.equals(description, that.description) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, citizenId, doctorId, appointmentDatetime, description, notes);
    }

    @ManyToOne
    @JoinColumn(name = "citizen_id", referencedColumnName = "id", nullable = false)
    public Citizen getCitizenByCitizenId() {
        return citizenByCitizenId;
    }

    public void setCitizenByCitizenId(Citizen citizenByCitizenId) {
        this.citizenByCitizenId = citizenByCitizenId;
    }

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
    public Doctor getDoctorByDoctorId() {
        return doctorByDoctorId;
    }

    public void setDoctorByDoctorId(Doctor doctorByDoctorId) {
        this.doctorByDoctorId = doctorByDoctorId;
    }
}
