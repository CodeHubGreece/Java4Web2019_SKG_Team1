package org.regeneration.efka.service;


import org.regeneration.efka.AppointmentData;
import org.regeneration.efka.entity.Appointment;
import org.regeneration.efka.entity.Citizen;
import org.regeneration.efka.entity.Doctor;
import org.regeneration.efka.entity.User;
import org.regeneration.efka.repository.AppointmentRepository;
import org.regeneration.efka.repository.CitizenRepository;
import org.regeneration.efka.repository.DoctorRepository;
import org.regeneration.efka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CitizenRepository citizenRepository;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;


    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, CitizenRepository citizenRepository, DoctorRepository doctorRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.citizenRepository = citizenRepository;
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findById(int id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> findCitizensAppointments(Principal loggedInPrincipal, Date fromDate, Date toDate, int specialtyId) {
        User loggedInUser = userRepository.findByUsername(loggedInPrincipal.getName());
        Citizen loggedInCitizen = citizenRepository.findById(loggedInUser.getCitizen().getId());

        List<Appointment> citizenAppointmentsSpecialty = new ArrayList<>();

        for (Appointment appointment : loggedInCitizen.getAppointments()) {
            if (appointment.getDoctor().getSpecialityId() == specialtyId) {
                if (appointment.getDatetime().before(toDate) && appointment.getDatetime().after(fromDate)) {
                    citizenAppointmentsSpecialty.add(appointment);
                }
            }
        }
        return citizenAppointmentsSpecialty;
    }

    public List<Appointment> findDoctorsAppointments(Principal loggedInPrincipal, Date fromDate, Date toDate, String description) {
        User loggedInUser = userRepository.findByUsername(loggedInPrincipal.getName());
        Doctor loggedInDoctor = doctorRepository.findById(loggedInUser.getDoctor().getId());

        return appointmentRepository.findAllByDoctorIdAndDatetimeBetweenAndDescriptionContainsOrderByDatetimeAsc(
                loggedInDoctor.getId(), fromDate, toDate, description);

    }

    public Appointment createAppointment(AppointmentData newAppointmentData, Principal loggedInPrincipal) {
        User loggedInUser = userRepository.findByUsername(loggedInPrincipal.getName());
        Citizen loggedInCitizen = citizenRepository.findById(loggedInUser.getCitizen().getId());

        if (!appointmentRepository.existsByCitizenIdAndDatetime(loggedInCitizen.getId(), newAppointmentData.getDatetime())
                && !appointmentRepository.existsByDoctorIdAndDatetime(newAppointmentData.getDoctorId(), newAppointmentData.getDatetime())) {

            Appointment newAppointment = new Appointment();
            newAppointment.setCitizen(loggedInCitizen);
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

    public Appointment updateAppointment(AppointmentData updatedAppointmentData) {
        Timestamp currentTime = Timestamp.valueOf(LocalDateTime.now());

        Appointment oldAppointment = appointmentRepository.findById(updatedAppointmentData.getId());
        if (!oldAppointment.getDatetime().before(currentTime)) {
            if (!appointmentRepository.existsByCitizenIdAndDatetime(oldAppointment.getCitizenId(), updatedAppointmentData.getDatetime())
                    && !appointmentRepository.existsByDoctorIdAndDatetime(oldAppointment.getDoctorId(), updatedAppointmentData.getDatetime())) {
                if (updatedAppointmentData.getDatetime() != null){
                    oldAppointment.setDatetime(updatedAppointmentData.getDatetime());
                }
                if (updatedAppointmentData.getDescription() != null){
                    oldAppointment.setDescription(updatedAppointmentData.getDescription());
                }
                if (updatedAppointmentData.getNotes() != null) {
                    oldAppointment.setNotes(updatedAppointmentData.getNotes());
                }
                return appointmentRepository.save(oldAppointment);
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Appointment overlaps");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Appointment has already taken place");
        }
    }

    public void deleteById(int id) {
        Appointment appointmentToDelete = appointmentRepository.findById(id);
        if (appointmentToDelete != null) {
            appointmentRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found");
        }
    }
}
