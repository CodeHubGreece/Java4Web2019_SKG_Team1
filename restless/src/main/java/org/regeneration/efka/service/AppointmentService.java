package org.regeneration.efka.service;


import org.regeneration.efka.NewAppointmentData;
import org.regeneration.efka.entity.Appointment;
import org.regeneration.efka.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findById(int id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> findAllByDatetimeBetweenAndDoctorId(Timestamp fromDate, Timestamp toDate, int doctorId) {
        return appointmentRepository.findAllByDatetimeBetweenAndDoctorId(fromDate, toDate, doctorId);
    }

    public List<Appointment> findAllByDatetimeBetweenAndDescription(Timestamp fromDate, Timestamp toDate, String description) {
        return appointmentRepository.findAllByDatetimeBetweenAndDescription(fromDate, toDate, description);

    }
    public Appointment createAppointment(NewAppointmentData newAppointmentData) {
        Appointment newAppointment = new Appointment();
        return appointmentRepository.save(newAppointment);
    }
}
