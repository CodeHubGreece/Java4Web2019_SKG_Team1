package org.regeneration.rest.restless.service;


import org.regeneration.rest.restless.entity.Appointment;
import org.regeneration.rest.restless.entity.Citizen;
import org.regeneration.rest.restless.repository.AppointmentRepository;
import org.regeneration.rest.restless.repository.CitizenRepository;
import org.regeneration.rest.restless.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public Optional<Appointment> findAppointmentsById(int id) {
        return appointmentRepository.findById(id);
    }

/*
    public List<Appointment> findAppointmentsByCitizen(Collection<Appointment> appointmentsById) {
        return appointmentRepository.findByAppointmentsById(appointmentsById);
    }

    public List<Appointment> findAppointmentsByDoctor(Collection<Appointment> appointmentsById) {
        return appointmentRepository.findByAppointmentsById(appointmentsById);
    }


//  --search tou citizen gia appointments--
    public List<Appointment> findAppointmentsByDatesAndBySpecialty(Date startDate, Date endDate, int specialtyId) {

        List<Appointment> dateAppointments = appointmentRepository.findAppointmentsBetweenDates(startDate, endDate);
        List<Appointment> specialtyAppointments = appointmentRepository.findAppointmentsBySpecialty(specialtyId);

        dateAppointments.retainAll(specialtyAppointments);

        return dateAppointments;
    }
*/
//  --search tou doctor gia appointments--
    public List<Appointment> findAppointmentsByDatesAndByDescription(Date startDate, Date endDate, String description) {

    //    List<Appointment> dateAppointments = appointmentRepository.findAppointmentsBetweenDates(startDate, endDate);
        List<Appointment> descriptionAppointments = appointmentRepository.findAppointmentsByDescription(description);

      //  dateAppointments.retainAll(descriptionAppointments);

      //  return dateAppointments;
        return null;

    }


    public Appointment createAppointment(Appointment newAppointment){ //Citizen citizen) {
        newAppointment.setDoctorId(newAppointment.getDoctorId());
        newAppointment.setDatetime(newAppointment.getDatetime());
        newAppointment.setDescription(newAppointment.getDescription());
        newAppointment.setNotes(newAppointment.getNotes());
        return appointmentRepository.save(newAppointment);
    }
}
