package org.regeneration.efka.service;


import org.regeneration.efka.NewAppointmentData;
import org.regeneration.efka.entity.Appointment;
import org.regeneration.efka.entity.Doctor;
import org.regeneration.efka.repository.AppointmentRepository;
import org.regeneration.efka.repository.CitizenRepository;
import org.regeneration.efka.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CitizenRepository citizenRepository;
    private final DoctorRepository doctorRepository;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, CitizenRepository citizenRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.citizenRepository = citizenRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findById(int id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> findAllByDatetimeBetweenAndSpecialtyId(int citizenId, Timestamp fromDate, Timestamp toDate, int specialtyId) {
        return (List<Appointment>) citizenRepository.findById(citizenId).getAppointments();
    }

    public List<Appointment> findAllByDatetimeBetweenAndDescription(Timestamp fromDate, Timestamp toDate, String description) {
        return appointmentRepository.findAllByDatetimeBetweenAndDescription(fromDate, toDate, description);

    }

    public Appointment createAppointment(NewAppointmentData newAppointmentData) {
        if (!appointmentRepository.existsByCitizenIdAndDatetime(newAppointmentData.getCitizenId(), newAppointmentData.getDatetime())
                && !appointmentRepository.existsByDoctorIdAndDatetime(newAppointmentData.getDoctorId(), newAppointmentData.getDatetime())) {
            Appointment newAppointment = new Appointment();
            newAppointment.setCitizen(citizenRepository.findById(newAppointmentData.getCitizenId()));
            newAppointment.setDoctor(doctorRepository.findById(newAppointmentData.getDoctorId()));
            newAppointment.setDatetime(newAppointmentData.getDatetime());
            newAppointment.setNotes(newAppointmentData.getNotes());
            newAppointment.setDescription(newAppointmentData.getDescription());
            appointmentRepository.save(newAppointment);
            return appointmentRepository.findById(newAppointment.getId());
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Appointment taken");
        }
    }
}
