package org.regeneration.efka.controller;

import org.regeneration.efka.AppointmentData;
import org.regeneration.efka.AppointmentSearchData;
import org.regeneration.efka.entity.Appointment;
import org.regeneration.efka.service.AppointmentService;
import org.regeneration.efka.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/")
public class AppointmentController {


    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, CitizenService citizenService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping("/appointments")
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/appointments/{id}")
    public Appointment findById(@PathVariable int id) {
        return appointmentService.findById(id);
    }



    /*@GetMapping("/appointment/citizen")
    public List<Appointment> findAppointmentsByCitizen(Citizen citizen) {
        return appointmentService.findAppointmentsByCitizen(citizenService.findAppointmentsByCitizen());
    }

    @GetMapping("/appointment/doctor")
    public List<Appointment> findAppointmentsByDoctor(Doctor doctor) {
        return appointmentService.findAppointmentsByDoctor(doctor.getAppointmentsById());
    }*/

    @PostMapping("/appointments/dates-specialty")
    public List<Appointment> findCitizensAppointments(@RequestBody AppointmentSearchData appointmentSearchData, Principal loggedInPrincipal) {
        return appointmentService.findCitizensAppointments(loggedInPrincipal,
                appointmentSearchData.getFromDate(),
                appointmentSearchData.getToDate(),
                appointmentSearchData.getSpecialtyId());

    }


    @PostMapping("/appointments/dates-description")
    public List<Appointment> findDoctorsAppointments(@RequestBody AppointmentSearchData appointmentSearchData, Principal loggedInPrincipal) {
        return appointmentService.findDoctorsAppointments(loggedInPrincipal,
                appointmentSearchData.getFromDate(),
                appointmentSearchData.getToDate(),
                appointmentSearchData.getDescription());
    }


    @PostMapping("/appointments/new")
    public Appointment newAppointment(@RequestBody AppointmentData newAppointmentData, Principal loggedInPrincipal) {

        return appointmentService.createAppointment(newAppointmentData, loggedInPrincipal);
    }

    @PutMapping("/appointments/update")
    public Appointment updateAppointment(@RequestBody AppointmentData updatedAppointmentData) {
        return appointmentService.updateAppointment(updatedAppointmentData);
    }

    @DeleteMapping("/appointments/{id}")
    public void deleteAppointment(@PathVariable int id) {
        appointmentService.deleteById(id);
    }


}